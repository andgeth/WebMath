package by.vsu.controllers;

import by.vsu.calculators.MathPhysicEquationCalculator;
import by.vsu.core.mathphysiceq.ellipticequation.SimpleGeometry;
import by.vsu.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Locale;

@Controller
public class MathPhysicController extends BaseController {

    @Autowired private MathPhysicEquationCalculator mathPhysicEquationCalculator;

    private String toString(double[][] arr) {
        Locale l = new Locale("en", "GB");
        StringBuilder sb = new StringBuilder();
        for (double[] anArr : arr) {
            //            sb.append("[");
            for (double anAnArr : anArr) {
                sb.append(String.format(l, "%.4f, ", anAnArr));
            }
            //            sb.append(String.format(l, "%.4f]", arr[i][arr[i].length - 1]));
        }
        return sb.toString();
    }

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
                           @RequestParam(value = "precision") Double precision,
                           Model model) {
        if (boundConditions != null) {
            double a = Double.parseDouble(xInterval.split(";")[0]);
            double b = Double.parseDouble(xInterval.split(";")[1]);
            double a1 = Double.parseDouble(tInterval.split(";")[0]);
            double b1 = Double.parseDouble(tInterval.split(";")[1]);
            String[] boundCondit = boundConditions.split(";");
            SimpleGeometry simpleGeometry = new SimpleGeometry(a, b, a1, b1, boundCondit, h, precision);
            double[][] solve = simpleGeometry.solve();
            prepareForDrawing(solve, xInterval, h, model);
            model.addAttribute("answer", toString(solve));
            return "answer";
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
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answer.length - 1; i++) {
                sb.append(round(answer[i][0], 4));
                for (int j = 1; j < answer[i].length; j++) {
                    sb.append(" ").append(round(answer[i][j], 4));
                }
                sb.append("<br>");
            }
            sb.append(round(answer[answer.length - 1][0], 4));
            for (int j = 1; j < answer[answer.length - 1].length; j++) {
                sb.append(" ").append(round(answer[answer.length - 1][j], 4));
            }
            prepareForDrawing(answer, xInterval, hx, model);
            model.addAttribute("answer", sb);
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
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answer.length - 1; i++) {
                sb.append(round(answer[i][0], 4));
                for (int j = 1; j < answer[i].length; j++) {
                    sb.append(" ").append(round(answer[i][j], 4));
                }
                sb.append("<br>");
            }
            sb.append(round(answer[answer.length - 1][0], 4));
            for (int j = 1; j < answer[answer.length - 1].length; j++) {
                sb.append(" ").append(round(answer[answer.length - 1][j], 4));
            }
            prepareForDrawing(answer, xInterval, hx, model);
            model.addAttribute("answer", sb);
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
