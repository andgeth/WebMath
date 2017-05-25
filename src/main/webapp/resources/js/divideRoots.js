$(function () {
    function extractFromJavaArray(array) {
        if (array === '' || array === null) {
            return array;
        }
        if (array[0] === '[') {
            array = array.substring(1, array.length - 1);
        }
        array = array.split(", ");
        if (array[0][0] === 'x' && array[1][0] === 'y') {
            array[0] = +(array[0].split('=')[1]);
            array[1] = +(array[1].split('=')[1]);
        }
        return array;
    }

    var func1Val = extractFromJavaArray($('#func1val').val()),
        func2Val = extractFromJavaArray($('#func2val').val());
    var xValues = extractFromJavaArray($('#xValues').val()),
        yValues = extractFromJavaArray($('#yValues').val());

    var d1 = [];
    var i;
    var xmax = Math.max.apply(null, xValues);
    var xmin = Math.min.apply(null, xValues);
    var ymax = yValues !== '' ? Math.max.apply(null, yValues) : Math.max.apply(null, func1Val);
    var ymin = yValues !== '' ? Math.min.apply(null, yValues) : Math.min.apply(null, func1Val);

    for (i = 0; i < xValues.length; i++) {
        d1.push([xValues[i], func1Val[i]]);
    }
    if (func2Val !== undefined) {
        var d2 = [];
        for (i = 0; i < yValues.length; i++) {
            d2.push([func2Val[i], yValues[i]]);
        }
    }

    var options = {
        yaxis: {
            show: true,
            max: ymax,
            min: ymin
        },
        xaxis: {
            show: true,
            max: xmax,
            min: xmin
        }
    };

    $.plot($("#placeholder"), [
        {
            data: d1,
            lines: {show: true}
        },
        {
            data: d2,
            lines: {show: true}
        }], options);
});