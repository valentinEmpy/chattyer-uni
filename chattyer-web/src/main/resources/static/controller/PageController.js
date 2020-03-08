sap.ui.define(["chattyer/controller/BaseController"], function (BaseController) {
  "use strict";

  return BaseController.extend("chattyer.controller.PageController", {
    onInit: function () {
      this._initHeader();
    },

    isLoggedIn: async function () {
      if (!this.getToken()) {
        return false;
      }
      var response = await this.getRequest("api/organizations").catch(() => {
        return { ok: false };
      });
      if (!response.ok) {
        return false;
      }
      return true;
    },

    _initHeader: function () {
      var oToolHeader = sap.ui.xmlfragment("chattyer.view.ToolHeader", this);
      this.getView().byId("page").setCustomHeader(oToolHeader);
    },

    onHomeIconPress: function () {
      this.getRouter().navTo("mainPage", true);
    },

    onLogout: function () {
      this.removeToken();
      window.location.href = "";
      location.reload(true);
    },
  });
});
