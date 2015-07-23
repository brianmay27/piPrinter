({
    handlePrint : function(cmp, event) {
        debugger;
        var file = event.getParam('file');
        var action = cmp.get('c.print');
        action.setParams({'file' : file});
        action.setCallback(this, function(ret) {
            if (action.getState === "SUCCESS") {
                alert("Success");
            }
        })
        $A.enqueueAction(action);
    }

})