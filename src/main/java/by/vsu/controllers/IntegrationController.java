package main.java.by.vsu.controllers;

import main.java.by.vsu.integration.RectanglesMethod;
import main.java.by.vsu.integration.SimpsonMethod;
import main.java.by.vsu.integration.TrapezeMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IntegrationController {

    @RequestMapping(value = "/rectanglesMethod")
    public String rectanglesMethod(
            @RequestParam(value = "function", required = false) String function,
            @RequestParam(value = "interval", required = false) String interval,
            @RequestParam(value = "h", required = false) Double h, Model model) {
        if (function != null) {
            double a = Double.parseDouble(interval.split(";")[0]);
            double b = Double.parseDouble(interval.split(";")[1]);
            try {
                if (a < b) {
                    model.addAttribute("interval", interval);
                    model.addAttribute("h", h);

                    RectanglesMethod rmL = new RectanglesMethod(function, a, b, h, 'L');
                    RectanglesMethod rmC = new RectanglesMethod(function, a, b, h, 'C');
                    RectanglesMethod rmR = new RectanglesMethod(function, a, b, h, 'R');
                    double[] resolve = {rmL.resolve(), rmC.resolve(), rmR.resolve()};
                    for (double i : resolve) {
                        if (Double.isNaN(i) == true) {
                            model.addAttribute("answerLeft", "На данном отрезке решений нет!");
                            return "rectanglesMethod";
                        }
                    }
                    model.addAttribute("answerLeft", "Левый: " + resolve[0]);
                    model.addAttribute("answerCenter", " Центральный: " + resolve[1]);
                    model.addAttribute("answerRight", " Правый: " + resolve[2]);
                } else {
                    model.addAttribute("answerLeft", "Введены неверные координаты отрезка!");
                }
            } catch (Exception ex) {
                model.addAttribute("answerLeft", "Функция введена некорректно!");
            }
        }
        return "rectanglesMethod";
    }

    @RequestMapping(value = "/trapezeMethod")
    public String trapezeMethod(
            @RequestParam(value = "function", required = false) String function,
            @RequestParam(value = "interval", required = false) String interval,
            @RequestParam(value = "h", required = false) Double h, Model model) {
        if (function != null) {
            double a = Double.parseDouble(interval.split(";")[0]);
            double b = Double.parseDouble(interval.split(";")[1]);
            try {
                if (a < b) {
                    model.addAttribute("interval", interval);
                    model.addAttribute("h", h);

                    TrapezeMethod rmL = new TrapezeMethod(function, a, b, h);
                    double resolve = rmL.resolve();
                    if (Double.isNaN(resolve)) {
                        model.addAttribute("answer", "На данном отрезке решений нет!");
                        return "rectanglesMethod";
                    }
                    model.addAttribute("answer", resolve);
                } else {
                    model.addAttribute("answer", "Введены неверные координаты отрезка!");
                }
            } catch (Exception ex) {
                model.addAttribute("answer", "Функция введена некорректно!");
            }
        }
        return "trapezeMethod";
    }

    @RequestMapping(value = "/simpsonMethod")
    public String simpsonMethod(
            @RequestParam(value = "function", required = false) String function,
            @RequestParam(value = "interval", required = false) String interval,
            @RequestParam(value = "h", required = false) Double h, Model model) {
        if (function != null) {
            double a = Double.parseDouble(interval.split(";")[0]);
            double b = Double.parseDouble(interval.split(";")[1]);
            try {
                if (a < b) {
                    model.addAttribute("interval", interval);
                    model.addAttribute("h", h);

                    SimpsonMethod rmL = new SimpsonMethod(function, a, b, h);
                    double resolve = rmL.resolve();
                    if (Double.isNaN(resolve)) {
                        model.addAttribute("answer", "На данном отрезке решений нет!");
                        return "rectanglesMethod";
                    }
                    model.addAttribute("answer", resolve);
                } else {
                    model.addAttribute("answer", "Введены неверные координаты отрезка!");
                }
            } catch (Exception ex) {
                model.addAttribute("answer", "Функция введена некорректно!");
            }
        }
        return "simpsonMethod";
    }

}