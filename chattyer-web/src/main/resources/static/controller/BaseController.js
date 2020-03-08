sap.ui.define(["sap/ui/core/mvc/Controller", "sap/ui/util/Storage"], function (Controller, Storage) {
  "use strict";

  var oStorage = new Storage(Storage.Type.local, "chattyer");
  var origin = window.location.origin;

  return Controller.extend("chattyer.controller.BaseController", {
    onInit: function () {},

    executeAsync: function (func) {
      setTimeout(func, 0);
    },

    postMultiPartRequest: async function (url = "", formData) {
      var response = await fetch(origin + "/" + url, {
        method: "POST",
        cache: "no-cache",
        headers: {
          Authorization: this.getToken(),
        },
        body: formData,
      });
      return response.json().then((data) => ({ ok: response.ok, body: data }));
    },

    postRequest: async function (url = "", body = {}) {
      var response = await fetch(origin + "/" + url, {
        method: "POST",
        mode: "cors",
        cache: "no-cache",
        headers: {
          "Content-Type": "application/json",
          Authorization: this.getToken(),
        },
        referrerPolicy: "no-referrer",
        body: JSON.stringify(body),
      });
      return response.json().then((data) => ({ ok: response.ok, body: data }));
    },

    getRequest: async function (url) {
      var response = await fetch(origin + "/" + url, {
        method: "GET",
        mode: "cors",
        cache: "no-cache",
        headers: {
          Authorization: this.getToken(),
        },
        referrerPolicy: "no-referrer",
      });
      return response.json().then((data) => ({ ok: response.ok, body: data }));
    },

    deleteRequest: async function (url) {
      var response = await fetch(origin + "/" + url, {
        method: "DELETE",
        mode: "cors",
        cache: "no-cache",
        headers: {
          Authorization: this.getToken(),
        },
        referrerPolicy: "no-referrer",
      });
      return { ok: response.ok };
    },

    getRouter: function () {
      return this.getOwnerComponent().getRouter();
    },

    getStorage: function () {
      return oStorage;
    },

    getToken: function () {
      return this.getStorage().get("token");
    },

    setToken: function (sToken) {
      this.getStorage().put("token", sToken);
    },

    removeToken: function () {
      this.getStorage().remove("token");
    },

    isTokenValid: function () {
      if (!this.getToken()) {
        return false;
      }
      return true;
    },

    showMessage: function (message) {
      sap.m.MessageToast.show(message, {
        width: "100%",
        offset: "0 -100",
      });
    },

    getErrorMessage: function (response) {
      var responseBody = response.body;
      if (!responseBody.message) {
        return "An unknown error has occurred!";
      }
      if (!responseBody.subErrors) {
        return responseBody.message;
      }
      var messages = [responseBody.message];
      responseBody.subErrors.forEach((subError) => {
        if (!("field" in subError) && !("value" in subError)) {
          if ("message" in subError) {
            messages.push(subError.message);
          }
        } else {
          messages.push(subError.field + ": " + subError.message);
        }
      });
      return messages.join("\r\n");
    },
  });
});
