package by.vsu.controllers;

import by.vsu.calculators.UnlinearEquationCalculator;
import by.vsu.core.analyzer.AlgebraicFunction;
import by.vsu.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

@Controller
public class UnlinearController {

    @Autowired private UnlinearEquationCalculator unlinearEquationCalculator;

    private double a, b;
    private double h;
    private int n;

    @GetMapping(value = "/simple-iteration")
    public String simpleIteration() {
        return "simple-iteration";
    }

    @GetMapping(value = "/chord")
    public String chord() {
        return "chord";
    }

    @GetMapping(value = "/dichotomy")
    public String dichotomy() {
        return "dichotomy";
    }

    @GetMapping(value = "/newton")
    public String newton() {
        return "newton";
    }

    @GetMapping(value = "/secant")
    public String secant() {
        return "secant";
    }

    @PostMapping(value = "/simple-iteration")
    public String simpleIteration(@RequestParam(value = "function") String function,
                                  @RequestParam(value = "interval") String interval,
                                  @RequestParam(value = "x0") String x0,
                                  @RequestParam(value = "e") Double e,
                                  Model model) {
        try {
            Double answer = this.unlinearEquationCalculator.simpleIteration(function, interval, x0, e);
            if (!answer.equals(Double.NaN)) {
                if (answer < 0) {
                    buildModel(function, String.valueOf((answer - 10) + ";" + 0), e, model);
                } else {
                    buildModel(function, String.valueOf(0 + ";" + (answer + 10)), e, model);
                }
                prepareForDrawing(function, model);
                model.addAttribute("answer", answer);
                return "answer";
            } else {
                model.addAttribute("error", "На данном отрезке решений нет или их несколько!");
            }
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception ex) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        return "simple-iteration";
    }

    @PostMapping(value = "/chord")
    public String chord(@RequestParam(value = "function") String function,
                        @RequestParam(value = "x1") String x1,
                        @RequestParam(value = "x2") String x2,
                        @RequestParam(value = "e") Double e,
                        Model model) {
        Double answer = this.unlinearEquationCalculator.chord(function, x1, x2, e);
        if (!answer.equals(Double.NaN)) {
            if (answer < 0) {
                buildModel(function, String.valueOf((answer - 10) + ";" + 0), e, model);
            } else {
                buildModel(function, String.valueOf(0 + ";" + (answer + 10)), e, model);
            }
            prepareForDrawing(function, model);
            model.addAttribute("answer", answer);
            return "answer";
        } else {
            model.addAttribute("error", "На данном отрезке решений нет или их несколько!");
        }
        return "chord";
    }

    @PostMapping(value = "/dichotomy")
    public String dichotomy(@RequestParam(value = "function") String function,
                            @RequestParam(value = "interval") String interval,
                            @RequestParam(value = "e") Double e,
                            Model model) {
        try {
            Double answer = this.unlinearEquationCalculator.dichotomy(function, interval, e);
            if (!answer.equals(Double.NaN)) {
                if (answer < 0) {
                    buildModel(function, String.valueOf((answer - 10) + ";" + 0), e, model);
                } else {
                    buildModel(function, String.valueOf(0 + ";" + (answer + 10)), e, model);
                }
                prepareForDrawing(function, model);
                model.addAttribute("answer", new BigDecimal(answer).setScale(5, RoundingMode.UP).doubleValue());
                return "answer";
            } else {
                model.addAttribute("answer", "На данном отрезке решений нет!");
            }
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception ex) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        return "dichotomy";
    }

    @PostMapping(value = "/newton")
    public String newton(@RequestParam(value = "function") String function,
                         @RequestParam(value = "x0") String x0,
                         @RequestParam(value = "e") Double e,
                         Model model) {
        try {
            Double answer = this.unlinearEquationCalculator.newton(function, x0, e);
            if (!answer.equals(Double.NaN)) {
                if (answer < 0) {
                    buildModel(function, String.valueOf((answer - 10) + ";" + 0), e, model);
                } else {
                    buildModel(function, String.valueOf(0 + ";" + (answer + 10)), e, model);
                }
                prepareForDrawing(function, model);
                model.addAttribute("answer", new BigDecimal(answer).setScale(8, RoundingMode.UP).doubleValue());
                return "answer";
            } else {
                model.addAttribute("error", "На данном отрезке решений нет или их несколько!");
            }
        } catch (Exception ex) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        return "newton";
    }

    @PostMapping(value = "/secant")
    public String secant(@RequestParam(value = "function") String function,
                         @RequestParam(value = "x1") String x1,
                         @RequestParam(value = "x2") String x2,
                         @RequestParam(value = "e") Double e,
                         Model model) {
        try {
            Double answer = this.unlinearEquationCalculator.secant(function, x1, x2, e);
            if (!answer.equals(Double.NaN)) {
                if (answer < 0) {
                    buildModel(function, String.valueOf((answer - 10) + ";" + 0), e, model);
                } else {
                    buildModel(function, String.valueOf(0 + ";" + (answer + 10)), e, model);
                }
                prepareForDrawing(function, model);
                model.addAttribute("answer", new BigDecimal(answer).setScale(5, RoundingMode.UP).doubleValue());
                return "answer";
            } else {
                model.addAttribute("error", "На данном отрезке решений нет или их несколько!");
            }
        } catch (Exception ex) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        return "secant";
    }

    private Model buildModel(String function, String interval, Double e, Model model) {
        model.addAttribute("function", function);
        model.addAttribute("e", e);
        model.addAttribute("interval", interval);

        a = Double.parseDouble(interval.split(";")[0]);
        b = Double.parseDouble(interval.split(";")[1]);
        h = (b - a) / 100;
        n = (int) ((b - a) / h) + 1;
        return model;
    }

    private void prepareForDrawing(String function, Model model) {
        AlgebraicFunction af = new AlgebraicFunction(function);
        double[] x = new double[n];
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            af.insertValue(a + h * i);
            y[i] = af.getValue();
            x[i] = a + h * i;
        }
        model.addAttribute("y", Arrays.toString(y));
        model.addAttribute("x", Arrays.toString(x));
//        model.addAttribute("answerVal", answerVal);
    }

}
