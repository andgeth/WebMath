package main.java.by.vsu.controllers;

import main.java.by.vsu.analyzer.AlgebraicFunction;
import main.java.by.vsu.interpolating.Lagrange;
import main.java.by.vsu.interpolating.Newton;
import main.java.by.vsu.interpolating.Spline;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InterpolationController {

    @RequestMapping(value = "/polyLagrange")
    public String interpolation(
            @RequestParam(value = "interval", required = false) String interval,
            @RequestParam(value = "xValues", required = false) String xValues,
            @RequestParam(value = "yValues", required = false) String yValues,
            @RequestParam(value = "n", required = false) Integer n,
            @RequestParam(value = "points", required = false) String strPoints,
            @RequestParam(value = "x", required = false) Double x, Model model) {
        if (interval != null) {
            double a = Double.parseDouble(interval.split(";")[0]);
            double b = Double.parseDouble(interval.split(";")[1]);
            if (a >= b) {
                model.addAttribute("interval", interval)
                    .addAttribute("xValues", xValues)
                    .addAttribute("yValues", yValues)
                    .addAttribute("n", n)
                    .addAttribute("points", strPoints)
                    .addAttribute("x", x)
                    .addAttribute("answer", "Интервал задан неверно!");
                return "polyLagrange";
            }
            String[] tmp_x = xValues.split(",");
            String[] tmp_y = yValues.split(",");
            double[] xPoints = new double[tmp_x.length];
            double[] yPoints = new double[tmp_y.length];
            for (int i = 0; i < tmp_x.length; i++) {
                xPoints[i] = Double.parseDouble(tmp_x[i]);
                yPoints[i] = Double.parseDouble(tmp_y[i]);
            }
            AlgebraicFunction resultFunction = new Lagrange(xPoints, yPoints, strPoints.split(";")).interpolate();
            resultFunction.insertValue(x);
            model.addAttribute("answer", resultFunction.getValue());
        }
        return "polyLagrange";
    }

    @RequestMapping(value = "/polyNewton")
    public String newton(
            @RequestParam(value = "interval", required = false) String interval,
            @RequestParam(value = "xValues", required = false) String xValues,
            @RequestParam(value = "yValues", required = false) String yValues,
            @RequestParam(value = "n", required = false) Integer n,
            @RequestParam(value = "points", required = false) String strPoints,
            @RequestParam(value = "x", required = false) Double x, Model model) {
        if (interval != null) {
            double a = Double.parseDouble(interval.split(";")[0]);
            double b = Double.parseDouble(interval.split(";")[1]);
            if (a >= b) {
                model.addAttribute("interval", interval)
                    .addAttribute("xValues", xValues)
                    .addAttribute("yValues", yValues)
                    .addAttribute("n", n)
                    .addAttribute("points", strPoints)
                    .addAttribute("x", x)
                    .addAttribute("answer", "Интервал задан неверно!");
                return "polyNewton";
            }
            String[] tmp_x = xValues.split(",");
            String[] tmp_y = yValues.split(",");
            double[] xPoints = new double[tmp_x.length];
            double[] yPoints = new double[tmp_y.length];
            for (int i = 0; i < tmp_x.length; i++) {
                xPoints[i] = Double.parseDouble(tmp_x[i]);
                yPoints[i] = Double.parseDouble(tmp_y[i]);
            }
            AlgebraicFunction resultFunction = new Newton(xPoints, yPoints, strPoints.split(";")).interpolate();
            resultFunction.insertValue(x);
            model.addAttribute("answer", resultFunction.getValue());
        }
        return "polyNewton";
    }

    @RequestMapping(value = "/spline")
    public String Spline(
            @RequestParam(value = "a", required = false) Double a,
            @RequestParam(value = "b", required = false) Double b,
            @RequestParam(value = "xValues", required = false) String xValues,
            @RequestParam(value = "yValues", required = false) String yValues,
            @RequestParam(value = "x", required = false) Double x, Model model) {
        if (a != null && b != null) {
            if (Double.compare(a, b) == -1) {
                String[] tmp_x = xValues.split(",");
                String[] tmp_y = yValues.split(",");
                double[] xPoints = new double[tmp_x.length];
                double[] yPoints = new double[tmp_y.length];
                for (int i = 0; i < tmp_x.length; i++) {
                    xPoints[i] = Double.parseDouble(tmp_x[i]);
                    yPoints[i] = Double.parseDouble(tmp_y[i]);
                }
                AlgebraicFunction[] resultFunctions = new Spline(xPoints, yPoints).createSpline();
                if (x >= xPoints[0] && x <= xPoints[1]) {
                    resultFunctions[0].insertValue(x);
                    model.addAttribute("answer", resultFunctions[0].getValue());
                } else {
                    for (int i = 1; i < resultFunctions.length; i++) {
                        if (x > xPoints[i] && x <= xPoints[i + 1]) {
                            resultFunctions[i].insertValue(x);
                            model.addAttribute("answer", resultFunctions[i].getValue());
                        }
                    }
                }
            } else {
                model.addAttribute("answer", "Введены неверные координаты отрезков!");
            }
        }
        return "spline";
    }

}

