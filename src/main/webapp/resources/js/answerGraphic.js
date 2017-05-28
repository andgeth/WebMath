var isAnimated;
var delay = 100;

$(function () {
    var xAnswer = $('#xAnswer').val(),
        yAnswer = $('#yAnswer').val();
    var data = [];
    var xValues = extractFromJavaArray($('#x').val()),
        funcValues = extractFromJavaArray($('#y').val()),
        funcPointValues = extractFromJavaArray($('#yPoints').val()),
        func1Values = extractFromJavaArray($('#y1').val()),
        functions = extractFromMultiJavaArray($('#yy').val());
    var options = {
        yaxis: {
            show: true,
            max: 5,
            min: -5
        },
        xaxis: {
            show: true,
            max: Math.max.apply(null, xValues),
            min: Math.min.apply(null, xValues)
        }
    };
    isAnimated = false;

    if (functions !== '') {
        data = drawMultipleGraphics(functions, xValues, options);
    } else if (func1Values !== '') {
        data = drawTwoCrossedGraphics(funcValues, func1Values, xValues, options);
    } else if (funcPointValues !== '') {
        data = drawPointsGraphic(funcPointValues, xValues, options);
    } else {
        data = drawSingleGraphic(xValues, funcValues, xAnswer, yAnswer, options);
    }

    var plot = $.plot($('#placeholder'), data, options);

    $('#animationBtn').click(function() {
        if (!isAnimated) {
            isAnimated = true;
            $(this).val('График');
            animate(plot, data);
        } else {
            isAnimated = false;
            $(this).val('Анимация');
            plot = $.plot($('#placeholder'), data, options);
        }
    });

    $('#delay').change(function() {
        var tmp = +$(this).val();
        delay = tmp >= 0 ? tmp : delay;
    })
});

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

function drawSingleGraphic(xValues, funcValues, xAnswer, yAnswer, options) {
    var ymax = +funcValues[0],
        ymin = +funcValues[0];
    var d = [];
    for (var i = 0; i < xValues.length; i++) {
        d.push([+xValues[i], +funcValues[i]]);
        if (+funcValues[i] > ymax) {
            ymax = +funcValues[i];
        } else if (+funcValues[i] < ymin) {
            ymin = +funcValues[i];
        }
    }
    buildOptions(options, ymax, ymin);
    return [
        {
            data: d,
            lines: { show: true }
        },
        {
            data: [[+xAnswer, +yAnswer]],
            points: {
                show: true,
                radius: 4
            }
        }];
}

function drawPointsGraphic(funcPointValues, xValues, options) {
    var ymax = +funcPointValues[0],
        ymin = +funcPointValues[0];
    var d = [];
    for (var i = 0; i < xValues.length; i++) {
        d.push([+xValues[i], +funcPointValues[i]]);
        if (+funcPointValues[i] > ymax) {
            ymax = +funcPointValues[i];
        } else if (+funcPointValues[i] < ymin) {
            ymin = +funcPointValues[i];
        }
    }
    buildOptions(options, ymax, ymin);
    return [
        {
            data: d,
            points: {
                show: true,
                radius: 4
            }
        }];
}

function drawTwoCrossedGraphics(funcValues, func1Values, xValues, options) {
    var ymax = +funcValues[0],
        ymin = +funcValues[0];
    var d1 = [],
        d2 = [];
    for (var i = 0; i < xValues.length; i++) {
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
    buildOptions(options, ymax, ymin);
    return [
        {
            data: d1,
            lines: { show: true }
        },
        {
            data: d2,
            lines: { show: true }
        }];
}

function drawMultipleGraphics(functions, xValues, options) {
    var ymax = 0,
        ymin = 0;
    var d = [];
    for (var i = 0; i < functions.length; i++) {
        var temp = [];
        for (var j = 0; j < functions[i].length; j++) {
            temp.push([+xValues[j], functions[i][j]]);
            ymax = +functions[i][j] > ymax ? +functions[i][j] : ymax;
            ymin = +functions[i][j] < ymin ? +functions[i][j] : ymin;
        }
        d.push({ data: temp, lines: { show: true } });
    }
    buildOptions(options, ymax, ymin);
    return d;
}

function buildOptions(options, ymax, ymin) {
    options.yaxis.max = ymax;
    options.yaxis.min = ymin;
}

function animate(plot, data) {
    var i = 0;
    var inc = 1;

    function update() {
        if (!isAnimated) return;
        plot.setData([data[i]]);
        plot.draw();
        if(i === data.length - 1)
            inc = -1;
        else if(i === 0)
            inc = 1;
        i += inc;
        setTimeout(update, delay);
    }
    update();
}