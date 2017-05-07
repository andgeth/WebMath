package main.java.by.vsu.controllers.diffsys;

import main.java.by.vsu.analyzer.algebra.VariableValuePair;
import main.java.by.vsu.diffsys.RungeKutta;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.RoundingMode;
import java.util.Arrays;

@Controller
public class RungeKuttaSystemController
{
    @RequestMapping("/rungeKuttaSystem")
    public String rungeKuttaSystem(
            @RequestParam(value = "functions", required = false) String functions,
            @RequestParam(value = "interval", required = false) String interval,
            @RequestParam(value = "y0", required = false) String y0,
            @RequestParam(value = "z0", required = false) String z0,
            @RequestParam(value = "h", required = false) Double h,
            Model model)
    {
        if (functions != null)
        {
            double a = Double.parseDouble(interval.split(";")[0]);
            double b = Double.parseDouble(interval.split(";")[1]);
            if (h <= 0)
            {
                model.addAttribute("functions", functions);
                model.addAttribute("interval", interval);
                model.addAttribute("y0", y0);
                model.addAttribute("z0", z0);
                model.addAttribute("h", h);
                model.addAttribute("answer", "Шаг введен некорректно!");
                return "rungeKuttaSystem";
            }
            if (a > b)
            {
                model.addAttribute("functions", functions);
                model.addAttribute("interval", interval);
                model.addAttribute("y0", y0);
                model.addAttribute("z0", z0);
                model.addAttribute("h", h);
                model.addAttribute("answer", "Введены неверные координаты отрезков!");
                return "rungeKuttaSystem";
            }
            try
            {
                VariableValuePair[] vvp = {new VariableValuePair(y0), new VariableValuePair(z0)};
                RungeKutta rungeKutta = new RungeKutta(functions.split(";"), vvp, a, b, h);
                double[][] answer = rungeKutta.resolve(5, RoundingMode.UP);
                model.addAttribute("functions", functions);
                model.addAttribute("interval", interval);
                model.addAttribute("y0", y0);
                model.addAttribute("z0", z0);
                model.addAttribute("h", h);
                model.addAttribute("answer1", Arrays.toString(answer[0]));
                model.addAttribute("answer2", Arrays.toString(answer[1]));
                return "rungeKuttaSystem";
            }
            catch (Exception ex)
            {
                model.addAttribute("functions", functions);
                model.addAttribute("interval", interval);
                model.addAttribute("y0", y0);
                model.addAttribute("z0", z0);
                model.addAttribute("h", h);
                model.addAttribute("answer1", "Функция введена неверно!");
                return "rungeKuttaSystem";
            }
        }
        return "rungeKuttaSystem";
    }
}
