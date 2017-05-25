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

    function extractFromMultiJavaArray(array) {
        return (array === '' || array === null) ? array : array.split(';').map(function(item) {
            return extractFromJavaArray(item);
        });
    }

    var answer = extractFromJavaArray($('#answer').html());
    var xAnswer = $('#xAnswer').val();
    var yAnswer = $('#yAnswer').val();
    var d1 = [],
        d2 = [],
        data = [];
    var xValues = extractFromJavaArray($('#x').val()),
        funcValues = extractFromJavaArray($('#y').val()),
        funcPointValues = extractFromJavaArray($('#yPoints').val()),
        func1Values = extractFromJavaArray($('#y1').val()),
        functions = extractFromMultiJavaArray($('#yy').val());
    var i;
    var n = xValues.length;
    var ymax, ymin;
    var xmax = Math.max.apply(null, xValues),
        xmin = Math.min.apply(null, xValues);

    if (functions !== '') {
        ymax = 0;
        ymin = 0;
        for (i = 0; i < functions.length; i++) {
            var temp = [];
            for (var j = 0; j < functions[i].length; j++) {
                temp.push([+xValues[j], functions[i][j]]);
                ymax = +functions[i][j] > ymax ? +functions[i][j] : ymax;
                ymin = +functions[i][j] < ymin ? +functions[i][j] : ymin;
            }
            data.push({data: temp, lines: {show: true}});
        }
    } else if (func1Values !== '') {
        ymax = +funcValues[0];
        ymin = +funcValues[0];
        for (i = 0; i < n; i++) {
            d1.push([+xValues[i], +funcValues[i]]);
            d2.push([+xValues[i], +func1Values[i]]);
            ymax = (function() {
                var max = (+(funcValues[i]) > +(func1Values[i]) ? +(funcValues[i]) : +(func1Values[i]));
                return max > ymax ? max : ymax;
            })();
            ymin = (function() {
                var min = (+(funcValues[i]) < +(func1Values[i]) ? +(funcValues[i]) : +(func1Values[i]));
                return min < ymin ? min : ymin;
            })();
        }
        data.push({data: d1, lines: {show: true}}, {data: d2, lines: {show: true}});
    } else if (funcPointValues !== '') {
        ymax = +funcPointValues[0];
        ymin = +funcPointValues[0];
        for (i = 0; i < n; i++) {
            d1.push([+xValues[i], +funcPointValues[i]]);
            if (+funcPointValues[i] > ymax) {
                ymax = +funcPointValues[i];
            } else if (+funcPointValues[i] < ymin) {
                ymin = +funcPointValues[i];
            }
        }
        data.push({data: d1, points: {show: true, radius: 4}});
    } else {
        ymax = +funcValues[0];
        ymin = +funcValues[0];
        for (i = 0; i < n; i++) {
            d1.push([+xValues[i], +funcValues[i]]);
            if (+funcValues[i] > ymax) {
                ymax = +funcValues[i];
            } else if (+funcValues[i] < ymin) {
                ymin = +funcValues[i];
            }
        }
        data.push({data: d1, lines: {show: true}}, {data: [[+xAnswer, +yAnswer]], points: {show: true, radius: 4}});
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

    $.plot($("#placeholder"), data, options);
});