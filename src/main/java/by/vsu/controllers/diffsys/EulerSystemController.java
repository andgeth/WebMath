package main.java.by.vsu.controllers.diffsys;

import main.java.by.vsu.analyzer.algebra.VariableValuePair;
import main.java.by.vsu.diffsys.Euler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.RoundingMode;
import java.util.Arrays;

@Controller
public class EulerSystemController
{
    @RequestMapping("/eulerSystem")
    public String eulerSystem(
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
                return "eulerSystem";
            }
            if (a > b)
            {
                model.addAttribute("functions", functions);
                model.addAttribute("interval", interval);
                model.addAttribute("y0", y0);
                model.addAttribute("z0", z0);
                model.addAttribute("h", h);
                model.addAttribute("answer", "Введены неверные координаты отрезков!");
                return "eulerSystem";
            }
            try
            {
                VariableValuePair[] vvp = {new VariableValuePair(y0), new VariableValuePair(z0)};
                Euler euler = new Euler(functions.split(";"), vvp, a, b, h);
                double[][] answer = euler.resolve(5, RoundingMode.UP);
                model.addAttribute("functions", functions);
                model.addAttribute("interval", interval);
                model.addAttribute("y0", y0);
                model.addAttribute("z0", z0);
                model.addAttribute("h", h);
                model.addAttribute("answer1", Arrays.toString(answer[0]));
                model.addAttribute("answer2", Arrays.toString(answer[1]));
                return "eulerSystem";
            }
            catch (Exception ex)
            {
                model.addAttribute("functions", functions);
                model.addAttribute("interval", interval);
                model.addAttribute("y0", y0);
                model.addAttribute("z0", z0);
                model.addAttribute("h", h);
                model.addAttribute("answer", "Функция введена неверно!");
                return "eulerSystem";
            }
        }
        return "eulerSystem";
    }
}
