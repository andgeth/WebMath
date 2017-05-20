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
    // var answerVal = document.getElementById('answerVal').value;
    var d1 = [],
        d2 = [],
        data = [];
    var xValues = extractFromJavaArray($('#x').val()),
        funcValues = extractFromJavaArray($('#y').val()),
        func1Values = extractFromJavaArray($('#y1').val()),
        functions = extractFromMultiJavaArray($('#yy').val());
    // var coordinates = answerVal === undefined ? answer.split(", ") : [+answer, +answerVal];
    var i;
    var n = xValues.length;
    var ymax = +funcValues[0],
        ymin = +funcValues[0];

    if (functions !== '') {
        for (i = 0; i < functions.length; i++) {
            var temp = [];
            for (var j = 0; j < functions[i].length; j++) {
                temp.push([+xValues[j], functions[i][j]])
            }
            data.push({data: temp, lines: {show: true}});
        }
    } else if (func1Values !== '') {
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
    } else {
        for (i = 0; i < n; i++) {
            d1.push([+xValues[i], +(funcValues[i])]);
            if (+funcValues[i] > ymax) {
                ymax = +funcValues[i];
            }
        }
        data.push({data: d1, lines: {show: true}});
    }
    // d3.push([+answer[0], +answer[1]]);

    var options = {
        yaxis: {
            show: true,
            max: 2,
            min: -1
        },
        xaxis: {
            show: true,
            max: -1,
            min: -1.5
        }
    };

    $.plot($("#placeholder"), data, options);
});