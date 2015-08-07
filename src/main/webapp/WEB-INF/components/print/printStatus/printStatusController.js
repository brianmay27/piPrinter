({
    init : function(cmp) {
        var progress = cmp.get('m.progress');
        cmp.set('v._progress', progress);
        cmp.set('v._isPrinting', true);
        cmp.set('v._status', cmp.get('m.status'));
        var progressItems = [];
        for (var i = 0; i < progress/10; i++) {
            progressItems.push(i);
        }
        cmp.set('v._progressItems', progressItems);
    }
})