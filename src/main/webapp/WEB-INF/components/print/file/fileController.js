({
    click : function(cmp) {
        var evt = $A.get('e.print:startPrint');
        var file = cmp.get('v.path');
        evt.setParams({'file' : file});
        evt.fire();
    }
})