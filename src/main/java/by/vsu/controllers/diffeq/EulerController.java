package main.java.by.vsu.controllers.diffeq;

import main.java.by.vsu.analyzer.algebra.VariableValuePair;
import main.java.by.vsu.diffeq.Euler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.RoundingMode;
import java.util.Arrays;

@Controller
public class EulerController
{
	@RequestMapping("/euler")
	public String euler(
			@RequestParam(value = "function", required = false) String function,
			@RequestParam(value = "interval", required = false) String interval,
            @RequestParam(value = "y0", required = false) String y0,
			@RequestParam(value = "h", required = false) Double h,
            Model model)
    {
		if (function != null)
		{
            double a = Double.parseDouble(interval.split(";")[0]);
            double b = Double.parseDouble(interval.split(";")[1]);
            if (h <= 0)
			{
				model.addAttribute("function", function);
				model.addAttribute("interval", interval);
				model.addAttribute("y0", y0);
				model.addAttribute("h", h);
				model.addAttribute("answer", "Шаг введен некорректно!");
				return "euler";
			}
            if(a > b)
            {
                model.addAttribute("function", function);
                model.addAttribute("interval", interval);
                model.addAttribute("y0", y0);
                model.addAttribute("h", h);
                model.addAttribute("answer",
                        "Введены неверные координаты отрезков!");
                return "euler";
            }
            Euler euler = null;
            VariableValuePair vvPair = new VariableValuePair(y0);
            try
            {
                euler = new Euler(function, vvPair, a, b, h);
            }
            catch (Exception ex)
            {
                model.addAttribute("function", function);
                model.addAttribute("interval", interval);
                model.addAttribute("y0", y0);
                model.addAttribute("h", h);
                model.addAttribute("answer", "Функция введена не корректно!");
                return "euler";
            }
            double[] answer = euler.resolve(5, RoundingMode.UP);

            model.addAttribute("function", function);
            model.addAttribute("interval", interval);
            model.addAttribute("y0", y0);
            model.addAttribute("h", h);
            model.addAttribute("answer", Arrays.toString(answer));
        }
		return "euler";
	}
}
