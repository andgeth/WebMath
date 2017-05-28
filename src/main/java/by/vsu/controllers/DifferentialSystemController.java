package by.vsu.controllers;

import by.vsu.calculators.DifferentialSystemCalculator;
import by.vsu.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class DifferentialSystemController extends BaseController {

    @Autowired private DifferentialSystemCalculator differentialSystemCalculator;

    @GetMapping("/euler-system")
    public String eulerSystem() {
        return "euler-system";
    }

    @GetMapping("/runge-kutta-system")
    public String rungeKuttaSystem() {
        return "runge-kutta-system";
    }

    @PostMapping("/euler-system")
    public String eulerSystem(@RequestParam(value = "functions") String functions,
                              @RequestParam(value = "interval") String interval,
                              @RequestParam(value = "y0") String y0,
                              @RequestParam(value = "z0") String z0,
                              @RequestParam(value = "h") Double h,
                              Model model) {
        try {
            double[][] answer = this.differentialSystemCalculator.euler(functions, interval, y0, z0, h);
            prepareForDrawing(answer, interval, h, model);
            StringBuilder sb = new StringBuilder();
            for (double[] array : answer) {
                for (double element : array) {
                    sb.append(element).append(" ");
                }
                sb.append("\n");
            }
            model.addAttribute("answer", sb);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        buildErrorModel(functions, interval, y0, z0, model);
        return "euler-system";
    }

    @PostMapping("/runge-kutta-system")
    public String rungeKuttaSystem(@RequestParam(value = "functions") String functions,
                                   @RequestParam(value = "interval") String interval,
                                   @RequestParam(value = "y0") String y0,
                                   @RequestParam(value = "z0") String z0,
                                   @RequestParam(value = "h") Double h,
                                   Model model) {
        try {
            double[][] answer = this.differentialSystemCalculator.rungeKutta(functions, interval, y0, z0, h);
            prepareForDrawing(answer, interval, h, model);
            StringBuilder sb = new StringBuilder();
            for (double[] array : answer) {
                for (double element : array) {
                    sb.append(element).append(" ");
                }
                sb.append("\n");
            }
            model.addAttribute("answer", sb);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        buildErrorModel(functions, interval, y0, z0, model);
        return "runge-kutta-system";
    }

    private void buildErrorModel(String functions, String interval, String y0, String z0, Model model) {
        model.addAttribute("functions", functions)
                .addAttribute("interval", interval)
                .addAttribute("y0", y0)
                .addAttribute("z0", z0);
    }

    private void prepareForDrawing(double[][] answer, String interval, double h, Model model) {
        double a = Double.valueOf(interval.split(";")[0]);
        double[] x = new double[answer[0].length];
        double[] y1 = new double[answer[0].length];
        double[] y2 = new double[answer[0].length];
        for (int i = 0; i < answer[0].length; i++) {
            y1[i] = answer[0][i];
            y2[i] = answer[1][i];
            x[i] = a + h * i;
        }
        model.addAttribute("x", Arrays.toString(x))
                .addAttribute("y", Arrays.toString(y1))
                .addAttribute("y1", Arrays.toString(y2))
                .addAttribute("drawable", true);
    }

}
