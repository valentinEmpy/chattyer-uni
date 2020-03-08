sap.ui.define(["chattyer/controller/PageController", "sap/m/MessageBox"], function (
  PageController,
  MessageBox
) {
  "use strict";

  var ws = null;

  return PageController.extend("chattyer.controller.MainPage", {
    onInit: async function () {
      PageController.prototype.onInit.call(this);
      this.getRouter().getRoute("mainPage").attachMatched(this._onRouteMatched, this);
      this.getView().setBusy(true);
      if (!(await this.isLoggedIn())) {
        this.getRouter().navTo("authPage", true);
        this.getView().setBusy(false);
        return;
      }
      this.getView().setBusy(false);
    },

    _onRouteMatched: async function () {
      if (!(await this.isLoggedIn())) {
        return;
      }
      this.getView().setBusy(true);
      this.connectChatbotWebSocket();
      this._refreshData(this);
      this.getView().setBusy(false);
    },

    _refreshData: async function () {
      try {
        var organizations = await this._fetchOrganizations();
        var spaces = await this._fetchSpaces();
        organizations.forEach((org) => {
          var orgSpaces = spaces.filter((space) => space.organization == org.id);
          org.spaces = orgSpaces;
        });
        var currentOrganizations = this.getOwnerComponent().getModel().getProperty("/organizations");
        if (!this._arraysAreIdentical(organizations, currentOrganizations)) {
          this.getOwnerComponent().getModel().setProperty("/organizations", organizations);
        }
        var chatbots = await this._fetchChatbots();
        spaces.forEach((space) => {
          var spaceChatbots = chatbots.filter((chatbot) => chatbot.space == space.id);
          space.chatbots = spaceChatbots;
        });
        var currentSpaces = this.getOwnerComponent().getModel().getProperty("/spaces");
        if (!this._arraysAreIdentical(spaces, currentSpaces)) {
          this.getOwnerComponent().getModel().setProperty("/spaces", spaces);
        }
        var currentChatbots = this.getOwnerComponent().getModel().getProperty("/chatbots");
        if (!this._arraysAreIdentical(chatbots, currentChatbots)) {
          this.getOwnerComponent().getModel().setProperty("/chatbots", chatbots);
        }
      } finally {
        this.getView().setBusy(false);
        setTimeout(this._refreshData.bind(this), 1000);
      }
    },

    _arraysAreIdentical: function (arr1, arr2) {
      if (!arr1 || !arr2) {
        return false;
      }
      return JSON.stringify(arr1) == JSON.stringify(arr2);
    },

    _fetchOrganizations: async function () {
      var response = await this.getRequest("api/organizations").catch(() => {
        this.showMessage("Connection failure...\r\nCould not fetch organizations");
        return [];
      });
      if (!response.ok) {
        this.showMessage(
          "Error fetching organizations!\r\nServer response: " + this.getErrorMessage(response)
        );
        return [];
      }
      return response.body;
    },

    _fetchSpaces: async function () {
      var response = await this.getRequest("api/spaces").catch(() => {
        this.showMessage("Connection failure...\r\nCould not fetch spaces");
        return [];
      });
      if (!response.ok) {
        this.showMessage("Error fetching spaces!\r\nServer response: " + this.getErrorMessage(response));
        return [];
      }
      return response.body;
    },

    _fetchChatbots: async function () {
      var response = await this.getRequest("api/chatbots").catch(() => {
        this.showMessage("Connection failure...\r\nCould not fetch chatbots");
        return [];
      });
      if (!response.ok) {
        this.showMessage("Error fetching chatbots!\r\nServer response: " + this.getErrorMessage(response));
        return [];
      }
      return response.body;
    },

    onOrganizationPress: function (oEvent, sOrganizationName, sOrganizationId) {
      var orgMode = this.getOwnerComponent().getModel().getProperty("/orgMode");
      if (orgMode == "ActionRemove") {
        this.deleteOrganization(sOrganizationName, sOrganizationId);
        return;
      }
      this.getOwnerComponent().getModel().setProperty("/selectedOrganizationId", sOrganizationId);
      this.getOwnerComponent().getModel().setProperty("/selectedOrganizationName", sOrganizationName);
      var oFilter = new sap.ui.model.Filter("organization", sap.ui.model.FilterOperator.EQ, sOrganizationId);
      this.getView().byId("spacesGrid").getBinding("items").filter(oFilter);
      var oContentColumnLayout = this.getView().byId("contentColumnLayout");
      if (oContentColumnLayout.getLayout() == "OneColumn") {
        oContentColumnLayout.setLayout("TwoColumnsMidExpanded");
      }
    },

    deleteOrganization: async function (sOrganizationName, sOrganizationId) {
      MessageBox.confirm("Delete organization '" + sOrganizationName + "'?", {
        onClose: async (oAction) => {
          if (oAction != "OK") {
            return;
          }
          var response = await this.deleteRequest("api/organizations/" + sOrganizationId).catch(() => {
            this.showMessage("Connection failure...\r\nCould not delete organization");
          });
          if (!response.ok) {
            this.showMessage(
              "Error deleting organization!\r\nServer response: " + this.getErrorMessage(response)
            );
          } else {
            this.getView().setBusy(true);
          }
        },
      });
    },

    onSpacePress: function (oEvent, sSpaceName, sSpaceId) {
      var orgMode = this.getOwnerComponent().getModel().getProperty("/spacesMode");
      if (orgMode == "ActionRemove") {
        this.deleteSpace(sSpaceName, sSpaceId);
        return;
      }
      this.getOwnerComponent().getModel().setProperty("/selectedSpaceId", sSpaceId);
      this.getOwnerComponent().getModel().setProperty("/selectedSpaceName", sSpaceName);
      var oFilter = new sap.ui.model.Filter("space", sap.ui.model.FilterOperator.EQ, sSpaceId);
      this.getView().byId("chatbotsGrid").getBinding("items").filter(oFilter);
      var oContentColumnLayout = this.getView().byId("contentColumnLayout");
      if (
        !oContentColumnLayout.getLayout().startsWith("ThreeColumns") ||
        oContentColumnLayout.getLayout().endsWith("EndHidden")
      ) {
        oContentColumnLayout.setLayout("ThreeColumnsEndExpanded");
      }
    },

    deleteSpace: async function (sSpaceName, sSpaceId) {
      MessageBox.confirm("Delete space '" + sSpaceName + "'?", {
        onClose: async (oAction) => {
          if (oAction != "OK") {
            return;
          }
          var response = await this.deleteRequest("api/spaces/" + sSpaceId).catch(() => {
            this.showMessage("Connection failure...\r\nCould not delete space");
          });
          if (!response.ok) {
            this.showMessage("Error deleting space!\r\nServer response: " + this.getErrorMessage(response));
          } else {
            this.getView().setBusy(true);
          }
        },
      });
    },

    onOrganizationsDeletePress: function () {
      var button = this.getView().byId("orgsDeleteButton");
      var orgMode = this.getOwnerComponent().getModel().getProperty("/orgMode");
      if (orgMode != "ActionRemove") {
        this.getOwnerComponent().getModel().setProperty("/orgMode", "ActionRemove");
        button.setType("Emphasized");
      } else {
        this.getOwnerComponent().getModel().setProperty("/orgMode", "Display");
        button.setType("Default");
      }
    },

    onOrganizationAddPress: function () {
      var self = this;
      var oNameLabel = new sap.m.Label({ text: "Name", labelFor: "organizationNameInput" });
      oNameLabel.addStyleClass("sapUiSmallMarginBegin");
      var oNameInput = new sap.m.Input("organizationNameInput", {
        width: "60%",
      });
      oNameInput.addStyleClass("sapUiSmallMarginBegin");
      var oDialog = new sap.m.Dialog({
        title: "New Organization",
        content: [oNameLabel, oNameInput],
        beginButton: new sap.m.Button({
          type: sap.m.ButtonType.Emphasized,
          text: "Add",
          press: async function () {
            var sOrganizationName = sap.ui.getCore().byId("organizationNameInput").getValue();
            var response = await self
              .postRequest("api/organizations", { name: sOrganizationName })
              .catch(() => {
                self.showMessage("Connection failure...\r\nCould not create organization");
              });
            if (!response.ok) {
              self.showMessage(
                "Error creating organization!\r\nServer response: " + self.getErrorMessage(response)
              );
            } else {
              self.getView().setBusy(true);
            }
            oDialog.close();
          },
        }),
        endButton: new sap.m.Button({
          text: "Cancel",
          press: function () {
            oDialog.close();
          },
        }),
        afterClose: function () {
          oDialog.destroy();
        },
      });
      oDialog.open();
    },

    onSpaceDeletePress: function () {
      var button = this.getView().byId("spacesDeleteButton");
      var spacesMode = this.getOwnerComponent().getModel().getProperty("/spacesMode");
      if (spacesMode != "ActionRemove") {
        this.getOwnerComponent().getModel().setProperty("/spacesMode", "ActionRemove");
        button.setType("Emphasized");
      } else {
        this.getOwnerComponent().getModel().setProperty("/spacesMode", "Display");
        button.setType("Default");
      }
    },

    onSpaceAddPress: function () {
      var self = this;
      var oNameLabel = new sap.m.Label({ text: "Name", labelFor: "spaceNameInput" });
      oNameLabel.addStyleClass("sapUiSmallMarginBegin");
      var oNameInput = new sap.m.Input("spaceNameInput", {
        width: "60%",
      });
      oNameInput.addStyleClass("sapUiSmallMarginBegin");
      var sSelectedOrganizationId = this.getOwnerComponent()
        .getModel()
        .getProperty("/selectedOrganizationId");
      var oDialog = new sap.m.Dialog({
        title: "New Space",
        content: [oNameLabel, oNameInput],
        beginButton: new sap.m.Button({
          type: sap.m.ButtonType.Emphasized,
          text: "Add",
          press: async function () {
            var sSpaceName = sap.ui.getCore().byId("spaceNameInput").getValue();
            var response = await self
              .postRequest("api/spaces", { name: sSpaceName, organization: sSelectedOrganizationId })
              .catch(() => {
                self.showMessage("Connection failure...\r\nCould not create space");
              });
            if (!response.ok) {
              self.showMessage("Error creating space!\r\nServer response: " + self.getErrorMessage(response));
            } else {
              self.getView().setBusy(true);
            }
            oDialog.close();
          },
        }),
        endButton: new sap.m.Button({
          text: "Cancel",
          press: function () {
            oDialog.close();
          },
        }),
        afterClose: function () {
          oDialog.destroy();
        },
      });
      oDialog.open();
    },

    onChatbotDeletePress: function () {
      var button = this.getView().byId("chatbotsDeleteButton");
      var chatbotsMode = this.getOwnerComponent().getModel().getProperty("/chatbotsMode");
      if (chatbotsMode != "ActionRemove") {
        this.getOwnerComponent().getModel().setProperty("/chatbotsMode", "ActionRemove");
        button.setType("Emphasized");
      } else {
        this.getOwnerComponent().getModel().setProperty("/chatbotsMode", "Display");
        button.setType("Default");
      }
    },

    onChatbotAddPress: function () {
      this._getAddChatbotDialog().open();
    },

    _getAddChatbotDialog: function () {
      if (this._oDialog) {
        this.getView().removeDependent(this._oDialog);
        this._oDialog.destroy();
      }
      this._oDialog = sap.ui.xmlfragment("chattyer.view.AddChatbotDialog", this);
      this.getView().addDependent(this._oDialog);
      return this._oDialog;
    },

    validateChatbotName: function () {
      var name = sap.ui.getCore().byId("chatbotNameInput").getValue();
      var wizard = sap.ui.getCore().byId("addChatbotWizard");
      var regex = /^[a-zA-Z_]+$/;

      if (name.length < 6 || name.length > 30 || !regex.test(name)) {
        this.getView().getModel().setProperty("/chatbotNameState", "Error");
        wizard.invalidateStep(sap.ui.getCore().byId("nameLanguageStep"));
      } else {
        this.getView().getModel().setProperty("/chatbotNameState", "None");
        wizard.validateStep(sap.ui.getCore().byId("nameLanguageStep"));
      }
    },

    onNameLanguageStepComplete: function () {
      sap.ui.getCore().byId("chatbotNameInput").setEnabled(false);
      sap.ui.getCore().byId("chatbotLanguageSelect").setEnabled(false);
    },

    addIntent: function () {
      var name = sap.ui.getCore().byId("intentNameInput").getValue();
      var intents = this.getView().getModel().getProperty("/intentsList");
      var wizard = sap.ui.getCore().byId("addChatbotWizard");
      if (!intents) {
        intents = [];
      }
      if (intents.find((item) => item.name == name)) {
        this.showMessage("Intent with Name " + name + " already exists.");
        return;
      }
      intents.push({ name: name });
      this.getView().getModel().setProperty("/intentsList", intents);
      wizard.validateStep(sap.ui.getCore().byId("intentsStep"));
    },

    deleteIntent: function (oEvent) {
      var wizard = sap.ui.getCore().byId("addChatbotWizard");
      var intents = this.getView().getModel().getProperty("/intentsList");
      var oList = oEvent.getSource(),
        oItem = oEvent.getParameter("listItem");

      // after deletion put the focus back to the list
      oList.attachEventOnce("updateFinished", oList.focus, oList);

      var intent = intents.find((item) => item.name == oItem.getTitle());
      const index = intents.indexOf(intent);
      if (index > -1) {
        intents.splice(index, 1);
      }
      this.getView().getModel().setProperty("/intentsList", intents);
      if (intents.length == 0) {
        wizard.invalidateStep(sap.ui.getCore().byId("intentsStep"));
      }
    },

    validateIntentName: function () {
      var name = sap.ui.getCore().byId("intentNameInput").getValue();
      var oAddIntentButton = sap.ui.getCore().byId("addIntentButton");

      if (name.length < 6 || name.length > 30) {
        this.getView().getModel().setProperty("/intentNameState", "Error");
        oAddIntentButton.setEnabled(false);
      } else {
        this.getView().getModel().setProperty("/intentNameState", "None");
        oAddIntentButton.setEnabled(true);
      }
    },

    onIntentsStepComplete: function () {
      var oIntentsList = sap.ui.getCore().byId("intentsList");
      var oAddIntentButton = sap.ui.getCore().byId("addIntentButton");
      oIntentsList.setMode("None");
      oAddIntentButton.setEnabled(false);
    },

    addSample: function () {
      var wizard = sap.ui.getCore().byId("addChatbotWizard");
      var text = sap.ui.getCore().byId("sampleTextInput").getValue();
      var intent = sap.ui.getCore().byId("sampleIntentSelect").getSelectedItem().getText();
      var samples = this.getView().getModel().getProperty("/samplesList");
      if (!samples) {
        samples = [];
      }
      samples.push({ text: text, intent: intent });
      this.getView().getModel().setProperty("/samplesList", samples);
      wizard.validateStep(sap.ui.getCore().byId("samplesStep"));
    },

    deleteSample: function (oEvent) {
      var wizard = sap.ui.getCore().byId("addChatbotWizard");
      var samples = this.getView().getModel().getProperty("/samplesList");
      var oList = oEvent.getSource(),
        oItem = oEvent.getParameter("listItem");

      // after deletion put the focus back to the list
      oList.attachEventOnce("updateFinished", oList.focus, oList);

      var sample = samples.find(
        (item) => item.text == oItem.getTitle() && item.intent == oItem.getDescription()
      );
      const index = samples.indexOf(sample);
      if (index > -1) {
        samples.splice(index, 1);
      }
      this.getView().getModel().setProperty("/sampesList", samples);
      if (samples.length == 0) {
        wizard.invalidateStep(sap.ui.getCore().byId("samplesStep"));
      }
    },

    validateSampleText: function () {
      var sName = sap.ui.getCore().byId("sampleTextInput").getValue();
      var oAddSampleButton = sap.ui.getCore().byId("addSampleButton");

      if (sName.length < 6 || sName.length > 256) {
        this.getView().getModel().setProperty("/sampleTextState", "Error");
        oAddSampleButton.setEnabled(false);
      } else {
        this.getView().getModel().setProperty("/sampleTextState", "None");
        oAddSampleButton.setEnabled(true);
      }
    },

    onSamplesStepComplete: function () {
      var samplesList = sap.ui.getCore().byId("samplesList");
      var oAddSampleButton = sap.ui.getCore().byId("addSampleButton");
      samplesList.setMode("None");
      oAddSampleButton.setEnabled(false);
    },

    addResponse: function () {
      var wizard = sap.ui.getCore().byId("addChatbotWizard");
      var type = sap.ui.getCore().byId("responseTypeSelect").getSelectedItem().getText();
      var intent = sap.ui.getCore().byId("responseIntentSelect").getSelectedItem().getText();
      var value = sap.ui.getCore().byId("responseValueInput").getValue();
      var responses = this.getView().getModel().getProperty("/responsesList");
      if (!responses) {
        responses = [];
      }
      if (responses.find((item) => item.intent == intent)) {
        this.showMessage(
          "Response for intent " + intent + " already exists! You can define only one response per intent"
        );
        return;
      }
      responses.push({ type: type, intent: intent, value: value });
      this.getView().getModel().setProperty("/responsesList", responses);
      wizard.validateStep(sap.ui.getCore().byId("responsesStep"));
    },

    deleteSample: function (oEvent) {
      var wizard = sap.ui.getCore().byId("addChatbotWizard");
      var responses = this.getView().getModel().getProperty("/responsesList");
      var oList = oEvent.getSource(),
        oItem = oEvent.getParameter("listItem");

      oList.attachEventOnce("updateFinished", oList.focus, oList);
      var response = responses.find((item) => item.type + " - " + item.intent == oItem.getDescription());
      const index = responses.indexOf(response);
      if (index > -1) {
        responses.splice(index, 1);
      }
      this.getView().getModel().setProperty("/responsesList", responses);
      if (responses.length == 0) {
        wizard.invalidateStep(sap.ui.getCore().byId("responsesStep"));
      }
    },

    validateResponseValue: function () {
      var sValue = sap.ui.getCore().byId("responseValueInput").getValue();
      var oAddResponseButton = sap.ui.getCore().byId("addResponseButton");

      if (sValue.length < 6 || sValue.length > 512) {
        this.getView().getModel().setProperty("/responseValueState", "Error");
        oAddResponseButton.setEnabled(false);
      } else {
        this.getView().getModel().setProperty("/responseValueState", "None");
        oAddResponseButton.setEnabled(true);
      }
    },

    onResponsesStepComplete: function () {
      var responsesList = sap.ui.getCore().byId("responsesList");
      var oAddResponseButton = sap.ui.getCore().byId("addResponseButton");
      responsesList.setMode("None");
      oAddResponseButton.setEnabled(false);
    },

    onAddChatbotWizardCompleted: async function () {
      var sChatbotName = sap.ui.getCore().byId("chatbotNameInput").getValue();
      var sChatbotLanguage = sap.ui.getCore().byId("chatbotLanguageSelect").getSelectedItem().getKey();
      var intentsList = this.getView().getModel().getProperty("/intentsList");
      var samplesList = this.getView().getModel().getProperty("/samplesList");
      var responsesList = this.getView().getModel().getProperty("/responsesList");

      var oChatbotDescriptor = {
        "schema-version": "1.0",
        name: sChatbotName,
        language: sChatbotLanguage,
        intents: intentsList,
        samples: samplesList,
        responses: responsesList,
      };
      var sChatbotDescriptor = jsyaml.safeDump(oChatbotDescriptor);
      var sSelectedSpaceId = this.getOwnerComponent().getModel().getProperty("/selectedSpaceId");

      var formData = new FormData();
      formData.append("space_id", sSelectedSpaceId);
      formData.append("chatbot_descriptor", new Blob([sChatbotDescriptor]), "chatbot_descriptor_yaml");
      this.getView().setBusy(true);
      this.getView().removeDependent(this._oDialog);
      this._oDialog.destroy();
      var response = await this.postMultiPartRequest("api/chatbots", formData).catch(() => {
        this.getView().setBusy(false);
        this.showMessage("Connection failure...\r\nCould not create chatbot");
      });
      this.getView().setBusy(true);
      if (!response.ok) {
        this.showMessage("Error creating chatbot!\r\nServer response: " + this.getErrorMessage(response));
      }
    },

    onBeforeAddChatbotDialogClose: function () {
      this.getView().getModel().setProperty("/chatbotNameState", null);
      this.getView().getModel().setProperty("/intentsList", []);
      this.getView().getModel().setProperty("/intentNameState", null);
      this.getView().getModel().setProperty("/samplesList", []);
      this.getView().getModel().setProperty("/sampleTextState", null);
      this.getView().getModel().setProperty("/responsesList", []);
      this.getView().getModel().setProperty("/responseValueState", null);
    },

    onChatbotPress: function (oEvent, sChatbotName, sChatbotId) {
      var orgMode = this.getOwnerComponent().getModel().getProperty("/chatbotsMode");
      if (orgMode == "ActionRemove") {
        this.deleteChatbot(sChatbotName, sChatbotId);
        return;
      }
      var sSelectedChatbotId = this.getOwnerComponent().getModel().getProperty("/selectedChatbotId");
      if (sSelectedChatbotId == sChatbotId) {
        this.getView().byId("chatbotDialog").open();
        return;
      }
      this.getOwnerComponent().getModel().setProperty("/selectedChatbotId", sChatbotId);
      this.getView().byId("chatbotDialog").open();
      var oChatbotDialog = this.getView().byId("chatbotDialog");
      oChatbotDialog.addChatItem("Chatbot " + sChatbotName + " (id=" + sChatbotId+ ") has been selected! Chat now...", false);
    },

    deleteChatbot: async function (sChatbotName, sChatbotId) {
      MessageBox.confirm("Delete chatbot '" + sChatbotName + "'?", {
        onClose: async (oAction) => {
          if (oAction != "OK") {
            return;
          }
          this.getView().setBusy(true);
          var response = await this.deleteRequest("api/chatbots/" + sChatbotId).catch(() => {
            this.showMessage("Connection failure...\r\nCould not delete chatbot");
          });
          if (!response.ok) {
            this.showMessage("Error deleting chatbot!\r\nServer response: " + this.getErrorMessage(response));
          }
        },
      });
    },

    onChatMessageSent: function (oEvent) {
      this.sendChatbotMessage(oEvent.getParameter("text"));
    },

    connectChatbotWebSocket: function () {
      var wsProtocol = window.location.protocol.endsWith("s:") ? "wss" : "ws";
      var socket = new WebSocket(wsProtocol + "://" + window.location.host + "/api/websocket/chatbots/websocket");
      ws = Stomp.over(socket);

      var oChatbotDialog = this.getView().byId("chatbotDialog");
      ws.connect(
        {},
        function (frame) {
          ws.subscribe("/user/queue/errors", function (message) {
            oChatbotDialog.addChatItem("Error: " + message.body, false);
          });

          ws.subscribe("/user/queue/reply", function (message) {
            oChatbotDialog.addChatItem(message.body, false);
          });
        },
        function (error) {
          alert(
            "Chatbot communication is impossible! Error establishing connection to remote server! " + error
          );
        }
      );
    },

    sendChatbotMessage: function (message) {
      var sSelectedChatbotId = this.getOwnerComponent().getModel().getProperty("/selectedChatbotId");
      var oChatbotDialog = this.getView().byId("chatbotDialog");
      if (!sSelectedChatbotId) {
        oChatbotDialog.addChatItem(
          "No chatbot selected! Please click on a chatbot before trying to communicate",
          false
        );
        return;
      }
      ws.send(
        "/api/websocket/chatbots/" + sSelectedChatbotId + "/reply",
        {},
        JSON.stringify({ text: message })
      );
    },
  });
});
