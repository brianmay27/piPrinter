({
    upload : function(cmp) {
        var x3g = document.getElementById('x3g');
        var gcode = document.getElementById('gCode');

        var formDate = new FormData();
        if (x3g.files.length == 1) {
            formDate.append('print', x3g.files[0]);
        }
        if (gcode.files.length == 1) {
            formDate.append('print', gcode.files[0]);
        }

        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/fileUpload', true);

        xhr.onload = function() {
            if (xhr.status == 200) {
                //success
                alert('success');
            }
        };

        xhr.send(formDate);
    }
})