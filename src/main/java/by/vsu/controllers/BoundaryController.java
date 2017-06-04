package by.vsu.controllers;

import by.vsu.calculators.BoundaryTaskCalculator;
import by.vsu.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class BoundaryController extends BaseController {

    @Autowired private BoundaryTaskCalculator boundaryTaskCalculator;

    @GetMapping(value = "/nets")
    public String nets() {
        return "nets";
    }

    @GetMapping(value = "/reduction")
    public String reduction() {
        return "reduction";
    }

    @GetMapping(value = "/shoot")
    public String shoot() {
        return "shoot";
    }

    @PostMapping(value = "/nets")
    public String nets(@RequestParam(value = "functions") String functions, @RequestParam(value = "startCondition") String startCondition,
                      @RequestParam(value = "endCondition") String endCondition, @RequestParam(value = "interval") String interval,
                      @RequestParam(value = "h") Double h, Model model) {
        try {
            double[] answer = this.boundaryTaskCalculator.nets(functions, startCondition, endCondition, interval, h);
            String[][] strings = new String[1][answer.length];
            for (int i = 0; i < strings.length; i++) {
                    strings[0][i] = String.valueOf(round(answer[i], 4));
            }
            model.addAttribute("answer", strings);
            prepareForDrawing(answer, interval, h, model);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        buildErrorModel(functions, startCondition, endCondition, interval, h, model);
        return "nets";
    }

    @PostMapping("/reduction")
    public String Reduction(@RequestParam(value = "functions") String functions, @RequestParam(value = "startCondition") String startCondition,
                            @RequestParam(value = "endCondition") String endCondition, @RequestParam(value = "interval") String interval,
                            @RequestParam(value = "h") Double h, Model model) {
        try {
            double[] answer = this.boundaryTaskCalculator.reduction(functions, startCondition, endCondition, interval, h);
            model.addAttribute("answer", Arrays.toString(answer));
            prepareForDrawing(answer, interval, h, model);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        buildErrorModel(functions, startCondition, endCondition, interval, h, model);
        return "reduction";
    }

    @PostMapping("/shoot")
    public String shoot(@RequestParam(value = "functions") String functions, @RequestParam(value = "startCondition") String startCondition,
                        @RequestParam(value = "endCondition") String endCondition, @RequestParam(value = "shootAngles") String shootAngles,
                        @RequestParam(value = "initValue") Double initValue, @RequestParam(value = "interval") String interval,
                        @RequestParam(value = "h") Double h, @RequestParam(value = "e") Double e, Model model) {
        try {
            double[] answer = this.boundaryTaskCalculator.shoot(functions, startCondition, endCondition, shootAngles, initValue, interval, h, e);
            String[][] strings = new String[1][answer.length];
            for (int i = 0; i < answer.length; i++) {
                strings[0][i] = String.valueOf(round(answer[i], 4));
            }
            model.addAttribute("answer", strings);
            prepareForDrawing(answer, interval, h, model);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        buildErrorModel(functions, startCondition, endCondition, shootAngles, initValue, interval, h, e, model);
        return "shoot";
    }

    private void buildErrorModel(String functions, String startCondition, String endCondition, String interval, double h,
                                 Model model) {
        model.addAttribute("functions", functions)
                .addAttribute("startCondition", startCondition)
                .addAttribute("endCondition", endCondition)
                .addAttribute("interval", interval)
                .addAttribute("h", h);
    }

    private void buildErrorModel(String functions, String startCondition, String endCondition, String shootAngles,
                                 double initValue, String interval, double h, double e, Model model) {
        buildErrorModel(functions, startCondition, endCondition, interval, h, model);
        model.addAttribute("shootAngles", shootAngles)
                .addAttribute("initValue", initValue)
                .addAttribute("e", e);
    }

    private void prepareForDrawing(double[] answer, String interval, double h, Model model) {
        double a = Double.valueOf(interval.split(";")[0]);
        double[] x = new double[answer.length];
        double[] y = new double[answer.length];
        for (int i = 0; i < answer.length; i++) {
            y[i] = answer[i];
            x[i] = a + h * i;
        }
        model.addAttribute("x", Arrays.toString(x))
                .addAttribute("y", Arrays.toString(y))
                .addAttribute("drawable", true);
    }

}
