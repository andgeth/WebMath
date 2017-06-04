package by.vsu.controllers;

import by.vsu.calculators.NonlinearEquationCalculator;
import by.vsu.analyzer.AlgebraicFunction;
import by.vsu.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class NonlinearController extends BaseController {

    @Autowired private NonlinearEquationCalculator nonlinearEquationCalculator;

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
            double answer = this.nonlinearEquationCalculator.simpleIteration(function, interval, x0, e);
            prepareForDrawing(answer, function, (answer - 10) + ";" + (answer + 10), model);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception ex) {
            model.addAttribute("error", "Решение не найдено!");
        }
        model.addAttribute("function", function)
                .addAttribute("interval", interval)
                .addAttribute("x0", x0)
                .addAttribute("e", e);
        return "simple-iteration";
    }

    @PostMapping(value = "/chord")
    public String chord(@RequestParam(value = "function") String function,
                        @RequestParam(value = "x1") String x1,
                        @RequestParam(value = "x2") String x2,
                        @RequestParam(value = "e") Double e,
                        Model model) {
        try {
            double answer = this.nonlinearEquationCalculator.chord(function, x1, x2, e);
            prepareForDrawing(answer, function, (answer - 10) + ";" + (answer + 10), model);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception ex) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        model.addAttribute("function", function)
                .addAttribute("x1", x1)
                .addAttribute("x2", x2)
                .addAttribute("e", e);
        return "chord";
    }

    @PostMapping(value = "/dichotomy")
    public String dichotomy(@RequestParam(value = "function") String function,
                            @RequestParam(value = "interval") String interval,
                            @RequestParam(value = "e") Double e,
                            Model model) {
        try {
            double answer = this.nonlinearEquationCalculator.dichotomy(function, interval, e);
            prepareForDrawing(answer, function, (answer - 10) + ";" + (answer + 10), model);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        model.addAttribute("function", function)
                .addAttribute("interval", interval)
                .addAttribute("e", e);
        return "dichotomy";
    }

    @PostMapping(value = "/newton")
    public String newton(@RequestParam(value = "function") String function,
                         @RequestParam(value = "x0") String x0,
                         @RequestParam(value = "e") Double e,
                         Model model) {
        try {
            double answer = this.nonlinearEquationCalculator.newton(function, x0, e);
            prepareForDrawing(answer, function, (answer - 10) + ";" + (answer + 10), model);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception ex) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        model.addAttribute("function", function)
                .addAttribute("x0", x0)
                .addAttribute("e", e);
        return "newton";
    }

    @PostMapping(value = "/secant")
    public String secant(@RequestParam(value = "function") String function,
                         @RequestParam(value = "x1") String x1,
                         @RequestParam(value = "x2") String x2,
                         @RequestParam(value = "e") Double e,
                         Model model) {
        try {
            double answer = this.nonlinearEquationCalculator.secant(function, x1, x2, e);
            prepareForDrawing(answer, function, (answer - 10) + ";" + (answer + 10), model);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception ex) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        model.addAttribute("function", function)
                .addAttribute("x1", x1)
                .addAttribute("x2", x2)
                .addAttribute("e", e);
        return "secant";
    }

    private void prepareForDrawing(double answer, String function, String interval, Model model) {
        AlgebraicFunction af = new AlgebraicFunction(function);
        double a = Double.parseDouble(interval.split(";")[0]);
        double b = Double.parseDouble(interval.split(";")[1]);
        double h = (b - a) / 100;
        int n = (int) ((b - a) / h) + 1;
        double[] x = new double[n];
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            af.insertValue(a + h * i);
            y[i] = af.getValue();
            x[i] = a + h * i;
        }
        af.insertValue(answer);
        model.addAttribute("x", Arrays.toString(x))
                .addAttribute("y", Arrays.toString(y))
                .addAttribute("xAnswer", answer)
                .addAttribute("yAnswer", af.getValue())
                .addAttribute("answer", new String[][] {{ String.valueOf(answer) }})
                .addAttribute("drawable", true);

    }

}
