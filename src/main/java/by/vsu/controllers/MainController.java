package by.vsu.controllers;

import by.vsu.core.analyzer.AlgebraicFunction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class MainController extends BaseController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/help")
    public String help() {
        return "help";
    }

    @GetMapping(value = "/divide")
    public String divideRoots() {
        return "divide";
    }

    @PostMapping(value = "/divide")
    public String divideRoots(@RequestParam(value = "func1") String func1,
                              @RequestParam(value = "func2", required = false) String func2,
                              @RequestParam(value = "xInterval") String xInterval,
                              @RequestParam(value = "yInterval", required = false) String yInterval,
                              Model model) {
        if (func1 != null && xInterval != null) {
            double[] func1Values = new double[101];
            double[] func2Values = new double[101];
            double[] xValues = new double[101];
            double[] yValues = new double[101];
            double ax = Double.parseDouble(xInterval.split(";")[0]);
            double bx = Double.parseDouble(xInterval.split(";")[1]);
            double min = 0;
            double hx = (bx - ax) / 100;
            int n = 101;
            AlgebraicFunction af = new AlgebraicFunction(func1);

            for (int i = 0; i < n; i++) {
                xValues[i] = ax + i * hx;
                af.insertValue(xValues[i]);
                func1Values[i] = af.getValue();
                min = func1Values[i] < min ? func1Values[i] : min;
            }
            model.addAttribute("func1Values", Arrays.toString(func1Values))
                    .addAttribute("xValues", Arrays.toString(xValues));
            if (!func2.isEmpty()) {
                double ay = Double.parseDouble(yInterval.split(";")[0]);
                double by = Double.parseDouble(yInterval.split(";")[1]);
                double hy = (by - ay) / 100;
                af = new AlgebraicFunction(func2);
                for (int i = 0; i < n; i++) {
                    yValues[i] = ay + i * hy;
                    af.insertValue(yValues[i]);
                    func2Values[i] = af.getValue();
                }
                model.addAttribute("func2Values", Arrays.toString(func2Values))
                        .addAttribute("yValues", Arrays.toString(yValues));
            }
        }
        return "divide";
    }

}
