package main.java.by.vsu.controllers.unlinear;

import main.java.by.vsu.analyzer.AlgebraicFunction;
import main.java.by.vsu.analyzer.algebra.VariableValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import main.java.by.vsu.unlinear.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

@Controller
public class UnlinearController {

    private double a, b;
    private double h;
    private int n;

    private Model buildModel(String function, String interval, Double e, Model model) {
        model.addAttribute("function", function);
        model.addAttribute("e", e);
        model.addAttribute("interval", interval);

        a = Double.parseDouble(interval.split(";")[0]);
        b = Double.parseDouble(interval.split(";")[1]);
        h = (b - a) / 25000;
        n = (int) ((b - a) / h) + 1;
        return model;
    }

    private void prepareForDrawing(String function, double answer, Model model) {
        AlgebraicFunction af = new AlgebraicFunction(function);
        af.insertValue(answer);
        double answerVal = af.getValue();
        double[] x = new double[n];
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            af.insertValue(a + h * i);
            y[i] = af.getValue();
            x[i] = a + h * i;
        }
        model.addAttribute("y", Arrays.toString(y));
        model.addAttribute("x", Arrays.toString(x));
        model.addAttribute("answerVal", answerVal);
    }

    @RequestMapping(value = "/simpleIteration")
    public String simpleIteration(
            @RequestParam(value = "function", required = false) String function,
            @RequestParam(value = "interval", required = false) String interval,
            @RequestParam(value = "x0", required = false) String x0,
            @RequestParam(value = "e", required = false) Double e, Model model) {
        if (function != null) {
            a = Double.parseDouble(interval.split(";")[0]);
            b = Double.parseDouble(interval.split(";")[1]);
            VariableValuePair x0Pair = new VariableValuePair(x0);
            if (a > b) {
                model.addAttribute("answer", "Введены неверные координаты отрезков!");
            } else if (x0Pair.getValue() < a || x0Pair.getValue() > b) {
                model.addAttribute("answer", "Введите верное начальное приближение!");
            } else {
                try {
                    SimpleIteration simpleIteration = new SimpleIteration(function, x0Pair, a, b);
                    Double answer = simpleIteration.resolve(e);
                    if (!answer.equals(Double.NaN)) {
                        if (answer < 0) {
                            buildModel(function, String.valueOf((answer - 10) + ";" + 0), e, model);
                        } else {
                            buildModel(function, String.valueOf(0 + ";" + (answer + 10)), e, model);
                        }
                        prepareForDrawing(function, answer, model);
                        model.addAttribute("answer", answer);
                        return "answer";
                    } else {
                        model.addAttribute("answer", "На данном отрезке решений нет или их несколько!");
                    }
                } catch (Exception ex) {
                    model.addAttribute("answer", "Функция введена некорректно!");
                    return "simpleIteration";
                }
            }
        }
        return "simpleIteration";
    }

    @RequestMapping(value = "/chord")
    public String chord(
            @RequestParam(value = "function", required = false) String function,
            @RequestParam(value = "x1", required = false) String x1,
            @RequestParam(value = "x2", required = false) String x2,
            @RequestParam(value = "e", required = false) Double e, Model model) {
        if (function != null) {
            try {
                VariableValuePair[] vvp = {new VariableValuePair(x1), new VariableValuePair(x2)};
                Chord ch = new Chord(function, vvp[0].getValue(), vvp[1].getValue());
                Double answer = ch.resolve(e);
                if (!answer.equals(Double.NaN)) {
                    if (answer < 0) {
                        buildModel(function, String.valueOf((answer - 10) + ";" + 0), e, model).addAttribute("x1", x1).addAttribute("x2", x2);
                    } else {
                        buildModel(function, String.valueOf(0 + ";" + (answer + 10)), e, model).addAttribute("x1", x1).addAttribute("x2", x2);
                    }
                    prepareForDrawing(function, answer, model);
                    model.addAttribute("answer", new BigDecimal(answer).setScale(5, RoundingMode.UP).doubleValue());
                    return "answer";
                } else {
                    model.addAttribute("answer", "На данном отрезке решений нет или их несколько!");
                }
            } catch (Exception ex) {
                model.addAttribute("answer", "Функция введена не корректно!");
                return "chord";
            }
        }
        return "chord";
    }

    @RequestMapping(value = "/dichotomy")
    public String dichotomy(
            @RequestParam(value = "function", required = false) String function,
            @RequestParam(value = "interval", required = false) String interval,
            @RequestParam(value = "e", required = false) Double e, Model model) {
        if (function != null) {
            a = Double.parseDouble(interval.split(";")[0]);
            b = Double.parseDouble(interval.split(";")[1]);
            if (a > b) {
                model.addAttribute("answer", "Введены неверные координаты отрезков!");
            }
            try {
                Dichotomy dichotomy = new Dichotomy(function, a, b);
                Double answer = dichotomy.resolve(e);
                if (!answer.equals(Double.NaN)) {
                    if (answer < 0) {
                        buildModel(function, String.valueOf((answer - 10) + ";" + 0), e, model);
                    } else {
                        buildModel(function, String.valueOf(0 + ";" + (answer + 10)), e, model);
                    }
                    prepareForDrawing(function, answer, model);
                    model.addAttribute("answer", new BigDecimal(answer).setScale(5, RoundingMode.UP).doubleValue());
                    return "answer";
                } else {
                    model.addAttribute("answer", "На данном отрезке решений нет!");
                }

            } catch (Exception ex) {
                model.addAttribute("answer", "Функция введена не корректно!");
                return "dichotomy";
            }
        }
        return "dichotomy";
    }

    @RequestMapping(value = "/newton")
    public String newton(
            @RequestParam(value = "function", required = false) String function,
            @RequestParam(value = "x0", required = false) String x0,
            @RequestParam(value = "e", required = false) Double e, Model model) {
        if (function != null) {
            VariableValuePair x0Pair = new VariableValuePair(x0);
            try {
                Newton newton = new Newton(function, x0Pair);
                Double answer = newton.resolve(e);
                if (!answer.equals(Double.NaN)) {
                    if (answer < 0) {
                        buildModel(function, String.valueOf((answer - 10) + ";" + 0), e, model).addAttribute("x0", x0);
                    } else {
                        buildModel(function, String.valueOf(0 + ";" + (answer + 10)), e, model).addAttribute("x0", x0);
                    }
                    prepareForDrawing(function, answer, model);
                    model.addAttribute("answer", new BigDecimal(answer).setScale(8, RoundingMode.UP).doubleValue());
                    return "answer";
                } else {
                    model.addAttribute("answer", "На данном отрезке решений нет или их несколько!");
                }
            } catch (Exception ex) {
                model.addAttribute("answer", "Функция введена некорректно!");
                return "newton";
            }
        }
        return "newton";
    }

    @RequestMapping(value = "/secant")
    public String secant(
            @RequestParam(value = "function", required = false) String function,
            @RequestParam(value = "x1", required = false) String x1,
            @RequestParam(value = "x2", required = false) String x2,
            @RequestParam(value = "e", required = false) Double e, Model model) {
        if (function != null) {
            VariableValuePair[] vvp = {new VariableValuePair(x1), new VariableValuePair(x2)};
            try {
                Secant s = new Secant(function, vvp[0].getValue(), vvp[1].getValue());
                Double answer = s.resolve(e);
                if (!answer.equals(Double.NaN)) {
                    if (answer < 0) {
                        buildModel(function, String.valueOf((answer - 10) + ";" + 0), e, model).addAttribute("x1", x1).addAttribute("x2", x2);
                    } else {
                        buildModel(function, String.valueOf(0 + ";" + (answer + 10)), e, model).addAttribute("x1", x1).addAttribute("x2", x2);
                    }
                    prepareForDrawing(function, answer, model);
                    model.addAttribute("answer", new BigDecimal(answer).setScale(5, RoundingMode.UP).doubleValue());
                    return "answer";
                } else {
                    model.addAttribute("answer", "На данном отрезке решений нет!");
                }
            } catch (Exception ex) {
                model.addAttribute("answer", "Функция введена не корректно!");
                return "secant";
            }
        }
        return "secant";
    }

    @RequestMapping("/resetSecant")
    public String resetSecant(Model model) {
        model.addAttribute("function", "")
            .addAttribute("x1", "")
            .addAttribute("x2", "")
            .addAttribute("e", "");
        return "secantStart";
    }

    @RequestMapping("/resetNewton")
    public String resetNewton(Model model) {
        model.addAttribute("function", "")
            .addAttribute("x0", "")
            .addAttribute("e", "");
        return "newton";
    }

    @RequestMapping("/resetDichotomy")
    public String resetDichotomy(Model model) {
        model.addAttribute("function", "")
            .addAttribute("interval", "")
            .addAttribute("e", "");
        return "dichotomy";
    }

    @RequestMapping("/resetSimpleIteration")
    public String resetSimpleIteration(Model model) {
        model.addAttribute("function", "")
            .addAttribute("interval", "")
            .addAttribute("x0", "")
            .addAttribute("e", "");
        return "simpleIteration";
    }

    @RequestMapping("/resetChord")
    public String resetChord(Model model) {
        model.addAttribute("function", "")
            .addAttribute("x1", "")
            .addAttribute("x2", "")
            .addAttribute("e", "");
        return "chord";
    }

}
