package by.vsu.controllers;

import by.vsu.calculators.DifferentialEquationCalculator;
import by.vsu.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class DifferentialEquationsController extends BaseController {

    @Autowired private DifferentialEquationCalculator differentialEquationCalculator;

    @GetMapping("/euler")
    public String euler() {
        return "euler";
    }

    @GetMapping("/better-euler")
    public String betterEuler() {
        return "better-euler";
    }

    @GetMapping("/euler-cauchy")
    public String eulerCauchy() {
        return "euler-cauchy";
    }

    @GetMapping("/runge-kutta")
    public String rungeKutta() {
        return "runge-kutta";
    }

    @PostMapping("/euler")
    public String euler(@RequestParam(value = "function") String function,
                        @RequestParam(value = "interval") String interval,
                        @RequestParam(value = "y0") String y0,
                        @RequestParam(value = "h") Double h,
                        Model model) {
        try {
            double[] answer = this.differentialEquationCalculator.euler(function, interval, y0, h);
            String[][] strings = new String[1][answer.length];
            for (int i = 0; i < strings[0].length; i++) {
                strings[0][i] = String.valueOf(round(answer[i], 4));
            }
            prepareForDrawing(strings, answer, interval, h, model);
            return "answer";
        }
        catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        }
        catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        buildErrorModel(function, interval, y0, h, model);
        return "euler";
    }

    @PostMapping("/better-euler")
    public String betterEuler(@RequestParam(value = "function") String function,
                              @RequestParam(value = "interval") String interval,
                              @RequestParam(value = "y0") String y0,
                              @RequestParam(value = "h") Double h,
                              Model model) {
        try {
            double[] answer = this.differentialEquationCalculator.betterEuler(function, interval, y0, h);
            String[][] strings = new String[1][answer.length];
            for (int i = 0; i < strings[0].length; i++) {
                strings[0][i] = String.valueOf(round(answer[i], 4));
            }
            prepareForDrawing(strings, answer, interval, h, model);
            return "answer";
        }
        catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        }
        catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        buildErrorModel(function, interval, y0, h, model);
        return "better-euler";
    }

    @PostMapping("/euler-cauchy")
    public String eulerCauchy(@RequestParam(value = "function") String function,
                              @RequestParam(value = "interval") String interval,
                              @RequestParam(value = "y0") String y0,
                              @RequestParam(value = "h") Double h,
                              Model model) {
        try {
            double[] answer = this.differentialEquationCalculator.eulerCauchy(function, interval, y0, h);
            String[][] strings = new String[1][answer.length];
            for (int i = 0; i < strings[0].length; i++) {
                strings[0][i] = String.valueOf(round(answer[i], 4));
            }
            prepareForDrawing(strings, answer, interval, h, model);
            return "answer";
        }
        catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        }
        catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        buildErrorModel(function, interval, y0, h, model);
        return "euler-cauchy";
    }

    @PostMapping("/runge-kutta")
    public String rungeKutta(@RequestParam(value = "function") String function,
                             @RequestParam(value = "interval") String interval,
                             @RequestParam(value = "y0") String y0,
                             @RequestParam(value = "h") Double h,
                             Model model) {
        try {
            double[] answer = this.differentialEquationCalculator.rungeKutta(function, interval, y0, h);
            String[][] strings = new String[1][answer.length];
            for (int i = 0; i < strings[0].length; i++) {
                strings[0][i] = String.valueOf(round(answer[i], 4));
            }
            prepareForDrawing(strings, answer, interval, h, model);
            return "answer";
        }
        catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        }
        catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        buildErrorModel(function, interval, y0, h, model);
        return "runge-kutta";
    }

    private void buildErrorModel(String function, String interval, String y0, double h, Model model) {
        model.addAttribute("function", function)
                .addAttribute("interval", interval)
                .addAttribute("y0", y0)
                .addAttribute("h", h);
    }

    private void prepareForDrawing(String[][] strings, double[] answer, String interval, double h, Model model) {
        double a = Double.valueOf(interval.split(";")[0]);
        double[] x = new double[answer.length];
        for (int i = 0; i < answer.length; i++) {
            x[i] = a + h * i;
        }
        model.addAttribute("x", Arrays.toString(x))
                .addAttribute("yPoints", Arrays.toString(answer))
                .addAttribute("drawable", true)
                .addAttribute("answer", strings);
    }

}
