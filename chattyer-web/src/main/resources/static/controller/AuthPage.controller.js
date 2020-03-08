sap.ui.define(["chattyer/controller/BaseController"], function (BaseController) {
  "use strict";

  return BaseController.extend("chattyer.controller.AuthPage", {
    onInit: function () {
      BaseController.prototype.onInit.call(this);
      this._loginOnEnterPress();
    },

    _loginOnEnterPress: function () {
      $(document).keydown((evt) => {
        if (evt.keyCode == 13 && this.getView().getVisible()) {
          this.getView().byId("loginButton").firePress();
        }
      });
    },

    onLogin: function () {
      var oView = this.getView();
      oView.setBusy(true);
      var username = this.getView().byId("usernameInput").getValue();
      var password = this.getView().byId("passwordInput").getValue();
      this.postRequest("api/auth/token", { username: username, password: password }, false).then(
        (response) => {
          oView.setBusy(false);
          if (!response.ok) {
            this.showMessage("Login failed\r\nCheck your credentials");
            return;
          }
          var token = response.body.tokenType + " " + response.body.accessToken;
          this.setToken(token);
          this.getRouter().navTo("mainPage");
        }
      );
    },

    onRegister: function () {
      var oView = this.getView();
      oView.setBusy(true);
      var username = this.getView().byId("usernameInput").getValue();
      var password = this.getView().byId("passwordInput").getValue();
      this.postRequest("api/auth/signup", { username: username, password: password }, false).then(
        (response) => {
          oView.setBusy(false);
          if (!response.ok) {
            this.showMessage(this.getErrorMessage(response));
            return;
          }
          oView.byId("loginButton").firePress();
        }
      );
    },
  });
});
