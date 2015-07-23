({
    init : function(cmp) {
        var cmps = cmp.get('m.files');
        cmp.set('v._files', cmps);
        cmp.getEvent('startPrint').fire();
    }
})