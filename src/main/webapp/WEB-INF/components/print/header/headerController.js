({
    openSettings : function(cmp) {
        var evt = $A.getEvt("ui:openDialog");
        var dialogCmp = cmp.find('settingsDialog');
        evt.setParams({dialog : dialogCmp});
        evt.fire();
    }
})