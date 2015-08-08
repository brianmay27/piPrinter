({
    onSave : function(cmp) {
        var machine = cmp.find('machine').get('v.value');
        var port = cmp.find('port').get('v.value');
        var action = cmp.get('c.update');
        action.setParams({'machine': machine, 'port' : port});
        action.setCallback(this, function(ret) {
            if (ret.getState() === "SUCCESS") {
                $A.getEvt('ui:closeDialog').setParams({'dialog': cmp}).fire();
            }
        })
        $A.enqueueAction(action);
    }
})