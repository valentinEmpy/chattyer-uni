sap.ui.define(["sap/ui/core/UIComponent", "./model/models"], function (UIComponent, models) {
    "use strict";

    return UIComponent.extend("chattyer.Component", {
        metadata: {
            manifest: "json",
        },

        init: function () {
            UIComponent.prototype.init.apply(this, arguments);
            this.setModel(models.createDeviceModel(), "device");
            this.getRouter().initialize();
        },

        createContent: function () {
            return sap.ui.view("AppView", {
                viewName: "chattyer.view.App",
                type: "XML",
            });
        },
    });
});
