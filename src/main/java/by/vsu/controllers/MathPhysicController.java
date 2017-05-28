package by.vsu.controllers;

import by.vsu.calculators.MathPhysicEquationCalculator;
import by.vsu.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class MathPhysicController extends BaseController {

    @Autowired private MathPhysicEquationCalculator mathPhysicEquationCalculator;

    @GetMapping("parabolic-eq")
    public String parabolic() {
        return "parabolic-eq";
    }

    @GetMapping("hyperbolic-eq")
    public String hyperbolic() {
        return "hyperbolic-eq";
    }

    @GetMapping("elliptic-eq")
    public String elliptic() {
        return "elliptic-eq";
    }

    @PostMapping("elliptic-eq")
    public String elliptic(@RequestParam(value = "boundConditions") String boundConditions,
                           @RequestParam(value = "xInterval") String xInterval,
                           @RequestParam(value = "tInterval") String tInterval,
                           @RequestParam(value = "h") Double h,
                           @RequestParam(value = "e") Double e,
                           Model model) {
        try {
            double[][] answer = this.mathPhysicEquationCalculator.elliptic(xInterval, tInterval, boundConditions, h, e);
            String[][] strings = new String[answer.length][answer[0].length];
            for (int i = 0; i < strings.length; i++) {
                for (int j = 0; j < strings[i].length; j++) {
                    strings[i][j] = String.valueOf(round(answer[i][j], 4));
                }
            }
            prepareForDrawing(answer, xInterval, h, model);
            model.addAttribute("answer", strings);
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Что-то пошло не так:( Попробуйте ещё раз.");
        }
        return "elliptic-eq";
    }

    @PostMapping("parabolic-eq")
    public String parabolic(@RequestParam(value = "function") String function,
                            @RequestParam(value = "initCondition") String initCondition,
                            @RequestParam(value = "boundConditions") String boundConditions,
                            @RequestParam(value = "xInterval") String xInterval,
                            @RequestParam(value = "tInterval") String tInterval,
                            @RequestParam(value = "hx") Double hx,
                            @RequestParam(value = "ht") Double ht,
                            @RequestParam(value = "weight") Double weight,
                            Model model) {
        try {
            double[][] answer = this.mathPhysicEquationCalculator.parabolic(function, initCondition, boundConditions, xInterval, tInterval, hx, ht, weight);
            String[][] strings = new String[answer.length][answer[0].length];
            for (int i = 0; i < strings.length; i++) {
                for (int j = 0; j < strings[i].length; j++) {
                    strings[i][j] = String.valueOf(round(answer[i][j], 4));
                }
            }
            prepareForDrawing(answer, xInterval, hx, model);
            model.addAttribute("answer", strings);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Что-то пошло не так:( Попробуйте ещё раз.");
        }
        return "parabolic-eq";
    }

    @PostMapping("hyperbolic-eq")
    public String hyperbolic(@RequestParam(value = "initConditions") String initConditions,
                             @RequestParam(value = "boundConditions") String boundConditions,
                             @RequestParam(value = "xInterval") String xInterval,
                             @RequestParam(value = "tInterval") String tInterval,
                             @RequestParam(value = "hx") Double hx,
                             @RequestParam(value = "ht") Double ht,
                             Model model) {
        try {
            double[][] answer = this.mathPhysicEquationCalculator.hyperbolic(initConditions, boundConditions, xInterval, tInterval, hx, ht);
            String[][] strings = new String[answer.length][answer[0].length];
            for (int i = 0; i < strings.length; i++) {
                for (int j = 0; j < strings[i].length; j++) {
                    strings[i][j] = String.valueOf(round(answer[i][j], 4));
                }
            }
            prepareForDrawing(answer, xInterval, hx, model);
            model.addAttribute("answer", strings)
                    .addAttribute("animatable", true);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Что-то пошло не так:( Попробуйте ещё раз.");
        }
        return "hyperbolic-eq";
    }

    private void prepareForDrawing(double[][] answer, String xInterval, double h, Model model) {
        String[] xPoints = xInterval.split(";");
        double a = Double.valueOf(xPoints[0]);
        double[] x = new double[answer[0].length];
        for (int i = 0; i < x.length; i++) {
            x[i] = a + i * h;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(answer[0]));
        for (int i = 1; i < answer.length; i++) {
            sb.append(";").append(Arrays.toString(answer[i]));
        }
        model.addAttribute("x", Arrays.toString(x))
                .addAttribute("yy", sb)
                .addAttribute("drawable", true);
    }

}
