package main.java.by.vsu.controllers.boundary;

import main.java.by.vsu.boundarytask.NetsMethod;
import main.java.by.vsu.boundarytask.ReductionMethod;
import main.java.by.vsu.boundarytask.ShootMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.RoundingMode;
import java.util.Arrays;

@Controller
public class BoundaryController
{
    @RequestMapping(value = "/netsMethod")
    public String net(
            @RequestParam(value = "functions", required = false) String functions,
            @RequestParam(value = "conditionStart", required = false) String conditionStart,
            @RequestParam(value = "conditionEnd", required = false) String conditionEnd,
            @RequestParam(value = "interval", required = false) String interval,
            @RequestParam(value = "h", required = false) Double h,
            Model model)
    {
        if (functions != null)
        {
            double a = Double.parseDouble(interval.split(";")[0]);
            double b = Double.parseDouble(interval.split(";")[1]);
            model.addAttribute("functions", functions);
            model.addAttribute("conditionStart", conditionStart);
            model.addAttribute("conditionEnd", conditionEnd);
            model.addAttribute("interval", interval);
            model.addAttribute("h", h);
            if (h <= 0)
                model.addAttribute("answer", "Шаг задан не верно!");
            else if (a >= b)
                model.addAttribute("answer", "Интервал задан неверно!");
            else try
            {
                String[] arrFunctions = functions.split(";");
                String[] arrCondStart = conditionStart.split(";");
                String[] arrCondEnd = conditionEnd.split(";");
                NetsMethod netsMethod = new NetsMethod(arrFunctions[0], arrFunctions[1], arrFunctions[2], a, b, h,
                        Double.valueOf(arrCondStart[0]),
                        Double.valueOf(arrCondEnd[0]),
                        Double.valueOf(arrCondStart[1]),
                        Double.valueOf(arrCondEnd[1]),
                        Double.valueOf(arrCondStart[2]),
                        Double.valueOf(arrCondEnd[2]));
                double[] answer = netsMethod.resolve(5, RoundingMode.UP);
                model.addAttribute("answer", Arrays.toString(answer));
            }
            catch(Exception ex)
            {
                model.addAttribute("answer", "Функция введена неверно!");
                return "netsMethod";
            }
        }
        return "netsMethod";
    }

    @RequestMapping("/reduction")
    public String Reduction(
            @RequestParam(value = "functions", required = false) String functions,
            @RequestParam(value = "conditionStart", required = false) String conditionStart,
            @RequestParam(value = "conditionEnd", required = false) String conditionEnd,
            @RequestParam(value = "interval", required = false) String interval,
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
                model.addAttribute("conditionStart", conditionStart);
                model.addAttribute("conditionEnd", conditionEnd);
                model.addAttribute("interval", interval);
                model.addAttribute("h", h);
                model.addAttribute("answer", "Шаг введен некорректно!");
                return "reduction";
            }
            if (a >= b)
            {
                model.addAttribute("functions", functions);
                model.addAttribute("conditionStart", conditionStart);
                model.addAttribute("conditionEnd", conditionEnd);
                model.addAttribute("interval", interval);
                model.addAttribute("h", h);
                model.addAttribute("answer", "Интервал задан неверно!");
                return "reduction";
            }
            try
            {
                String[] arrFunctions = functions.split(";");
                String[] arrCondStart = conditionStart.split(";");
                String[] arrCondEnd = conditionEnd.split(";");
                ReductionMethod reductionMethod = new ReductionMethod(arrFunctions[0], arrFunctions[1], arrFunctions[2],
                        a, b, h,
                        Double.valueOf(arrCondStart[0]),
                        Double.valueOf(arrCondEnd[0]),
                        Double.valueOf(arrCondStart[1]),
                        Double.valueOf(arrCondEnd[1]),
                        Double.valueOf(arrCondStart[2]),
                        Double.valueOf(arrCondEnd[2]));
                double[] answer = reductionMethod.resolve(5, RoundingMode.UP);
                model.addAttribute("functions", functions);
                model.addAttribute("conditionStart", conditionStart);
                model.addAttribute("conditionEnd", conditionEnd);
                model.addAttribute("interval", interval);
                model.addAttribute("h", h);
                model.addAttribute("answer", Arrays.toString(answer));
                return "reduction";
            }
            catch(Exception ex)
            {
                model.addAttribute("functions", functions);
                model.addAttribute("conditionStart", conditionStart);
                model.addAttribute("conditionEnd", conditionEnd);
                model.addAttribute("interval", interval);
                model.addAttribute("h", h);
                model.addAttribute("answer", ex.getStackTrace().toString());
                return "reduction";
            }
        }
        return "reduction";
    }

    @RequestMapping("/shoot")
    public String shoot(
            @RequestParam(value = "functions", required = false) String functions,
            @RequestParam(value = "conditionStart", required = false) String conditionStart,
            @RequestParam(value = "conditionEnd", required = false) String conditionEnd,
            @RequestParam(value = "shootingAngles", required = false) String shootingAngles,
            @RequestParam(value = "initialValue", required = false) Double initialValue,
            @RequestParam(value = "interval", required = false) String interval,
            @RequestParam(value = "h", required = false) Double h,
            @RequestParam(value = "e", required = false) Double e,
            Model model)
    {
        if (functions != null)
        {
            double a = Double.parseDouble(interval.split(";")[0]);
            double b = Double.parseDouble(interval.split(";")[1]);
            if (h <= 0)
            {
                model.addAttribute("functions", functions);
                model.addAttribute("conditionStart", conditionStart);
                model.addAttribute("conditionEnd", conditionEnd);
                model.addAttribute("shootingAngles", shootingAngles);
                model.addAttribute("initialValue", initialValue);
                model.addAttribute("interval", interval);
                model.addAttribute("h", h);
                model.addAttribute("e", e);
                model.addAttribute("answer", "Шаг введен некорректно!");
                return "shoot";
            }
            if (a >= b)
            {
                model.addAttribute("functions", functions);
                model.addAttribute("conditionStart", conditionStart);
                model.addAttribute("conditionEnd", conditionEnd);
                model.addAttribute("shootingAngles", shootingAngles);
                model.addAttribute("initialValue", initialValue);
                model.addAttribute("interval", interval);
                model.addAttribute("h", h);
                model.addAttribute("e", e);
                model.addAttribute("answer", "Интервал задан неверно!");
                return "shoot";
            }
            try
            {
                String[] arrFunctions = functions.split(";");
                String[] arrCondStart = conditionStart.split(";");
                String[] arrCondEnd = conditionEnd.split(";");
                String[] arrShootAngles = shootingAngles.split(";");
                ShootMethod shootMethod = new ShootMethod(arrFunctions[0], arrFunctions[1], arrFunctions[2],
                        a, b, h,
                        Double.valueOf(arrCondStart[0]),
                        Double.valueOf(arrCondEnd[0]),
                        Double.valueOf(arrCondStart[1]),
                        Double.valueOf(arrCondEnd[1]),
                        Double.valueOf(arrCondStart[2]),
                        Double.valueOf(arrCondEnd[2]));
                shootMethod.setShootingAngles(new double[]{Double.valueOf(arrShootAngles[0]), Double.valueOf(arrShootAngles[1])});
                shootMethod.setInitialValues(initialValue);
                shootMethod.setPrecision(e);
                double[] answer = shootMethod.resolve(5, RoundingMode.UP);
                if(answer == null)
                    model.addAttribute("answer", "Количество итераций > 1000! Выберите другой угол.");
                else
                    model.addAttribute("answer", Arrays.toString(answer));
                model.addAttribute("functions", functions);
                model.addAttribute("conditionStart", conditionStart);
                model.addAttribute("conditionEnd", conditionEnd);
                model.addAttribute("shootingAngles", shootingAngles);
                model.addAttribute("initialValue", initialValue);
                model.addAttribute("interval", interval);
                model.addAttribute("h", h);
                model.addAttribute("e", e);
                return "answer";
            }
            catch(Exception ex)
            {
                model.addAttribute("functions", functions);
                model.addAttribute("conditionStart", conditionStart);
                model.addAttribute("conditionEnd", conditionEnd);
                model.addAttribute("shootingAngles", shootingAngles);
                model.addAttribute("initialValue", initialValue);
                model.addAttribute("interval", interval);
                model.addAttribute("h", h);
                model.addAttribute("e", e);
                model.addAttribute("answer", Arrays.toString(ex.getStackTrace()));
                return "shoot";
            }
        }
        return "shoot";
    }
}
