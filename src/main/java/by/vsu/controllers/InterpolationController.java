package by.vsu.controllers;

import by.vsu.calculators.InterpolationCalculator;
import by.vsu.core.math.objects.Spline;
import by.vsu.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class InterpolationController extends BaseController {

    @Autowired private InterpolationCalculator interpolationCalculator;

    @GetMapping(value = "/poly-lagrange")
    public String lagrange() {
        return "poly-lagrange";
    }

    @GetMapping(value = "/poly-newton")
    public String newton() {
        return "poly-newton";
    }

    @GetMapping(value = "/spline")
    public String spline() {
        return "spline";
    }

    @PostMapping(value = "/poly-lagrange")
    public String lagrange(@RequestParam(value = "xValues") String xValues,
                           @RequestParam(value = "yValues") String yValues,
                           @RequestParam(value = "points") String strPoints,
                           @RequestParam(value = "x") Double x,
                           Model model) {
        try {
            model.addAttribute("answer", this.interpolationCalculator.lagrange(xValues, yValues, strPoints, x))
                    .addAttribute("drawable", false);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        return "poly-lagrange";
    }

    @PostMapping(value = "/poly-newton")
    public String newton(@RequestParam(value = "xValues") String xValues,
                         @RequestParam(value = "yValues") String yValues,
                         @RequestParam(value = "points") String strPoints,
                         @RequestParam(value = "x") Double x,
                         Model model) {
        try {

            model.addAttribute("answer", this.interpolationCalculator.newton(xValues, yValues, strPoints, x))
                    .addAttribute("drawable", false);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        return "poly-newton";
    }

    @PostMapping(value = "/spline")
    public String spline(@RequestParam(value = "xValues") String xValues,
                         @RequestParam(value = "yValues") String yValues,
                         @RequestParam(value = "x") Double x,
                         Model model) {
        try {
            Spline spline = this.interpolationCalculator.spline(xValues, yValues, x);
            prepareForDrawing(spline, x, xValues, model);
            model.addAttribute("answer", spline.getValue(x));
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        return "spline";
    }

    private void prepareForDrawing(Spline spline, double xAnswer, String xValues, Model model) {
        String[] tmp_x = xValues.split(",");
        double a = Double.valueOf(tmp_x[0]);
        double b = Double.valueOf(tmp_x[tmp_x.length-1]);
        double h = (b - a) / 100;
        int n = (int) ((b - a) / h) + 1;
        double[] xArray = new double[n];
        double[] yArray = new double[n];
        for (int i = 0; i < n; i++) {
            yArray[i] = spline.getValue(a + h * i);
            xArray[i] = a + h * i;
        }

        model.addAttribute("x", Arrays.toString(xArray))
                .addAttribute("y", Arrays.toString(yArray))
                .addAttribute("xAnswer", xAnswer)
                .addAttribute("yAnswer", spline.getValue(xAnswer))
                .addAttribute("drawable", true);
    }

}

