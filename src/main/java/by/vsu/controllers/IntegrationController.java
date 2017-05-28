package by.vsu.controllers;

import by.vsu.calculators.IntegrationCalculator;
import by.vsu.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IntegrationController extends BaseController {

    @Autowired private IntegrationCalculator integrationCalculator;

    @GetMapping(value = "/rectangles")
    public String rectangles() {
        return "rectangles";
    }

    @GetMapping(value = "/trapeze")
    public String trapeze() {
        return "trapeze";
    }

    @GetMapping(value = "/simpson")
    public String simpson() {
        return "simpson";
    }

    @PostMapping(value = "/rectangles")
    public String rectangles(@RequestParam(value = "function") String function,
                             @RequestParam(value = "interval") String interval,
                             @RequestParam(value = "h") Double h,
                             Model model) {
        try {
            double[] answer = this.integrationCalculator.rectangles(function, interval, h);
            model.addAttribute("interval", interval);
            model.addAttribute("h", h);
            model.addAttribute("answerLeft", "Левый: " + answer[0]);
            model.addAttribute("answerCenter", " Центральный: " + answer[1]);
            model.addAttribute("answerRight", " Правый: " + answer[2]);
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        buildErrorModel(function, interval, h, model);
        return "rectangles";
    }

    @PostMapping(value = "/trapeze")
    public String trapezeMethod(@RequestParam(value = "function") String function,
                                @RequestParam(value = "interval") String interval,
                                @RequestParam(value = "h") Double h,
                                Model model) {
        try {
            double resolve = this.integrationCalculator.trapeze(function, interval, h);
            if (Double.isNaN(resolve)) {
                model.addAttribute("error", "На данном отрезке решений нет!");
            } else {
                model.addAttribute("answer", resolve);
                return "answer";
            }
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        buildErrorModel(function, interval, h, model);
        return "trapeze";
    }

    @PostMapping(value = "/simpson")
    public String simpson(@RequestParam(value = "function") String function,
                          @RequestParam(value = "interval") String interval,
                          @RequestParam(value = "h") Double h,
                          Model model) {
        try {
            double resolve = this.integrationCalculator.simpson(function, interval, h);
            if (Double.isNaN(resolve)) {
                model.addAttribute("error", "На данном отрезке решений нет!");
            } else {
                model.addAttribute("answer", resolve);
                return "answer";
            }
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Данные введены неверно!");
        }
        buildErrorModel(function, interval, h, model);
        return "simpson";
    }

    private void buildErrorModel(String function, String interval, double h, Model model) {
        model.addAttribute("function", function)
                .addAttribute("interval", interval)
                .addAttribute("h", h);
    }

}