$(function () {
    var interval = document.getElementById('interval').value.split(';');
    var func1Val = document.getElementById('func1val').value.split(';');
    var func2Val = document.getElementById('func2val').value.split(';');

    delete func1Val[func1Val.length - 1];

    var x = [];
    var d1 = [];
    var n = (Number(interval[1]) - Number(interval[0])) / 0.5 + 1;
    for (var i = 0; i < n; i++) {
        x.push(Number(interval[0]) + 0.5 * i);
        d1.push([x[i], func1Val[i]]);
    }
    if (func2Val !== undefined) {
        delete func2Val[func1Val.length - 1];
        var d2 = [];
        for (var i = 0; i < n; i++) {
            d2.push([func2Val[i], x[i]]);
        }
    }
    $.plot($("#placeholder"),
        [
            {
                data: d1,
                lines: {show: true}
            },
            {
                data: d2,
                lines: {show: true}
            }
        ]);
});