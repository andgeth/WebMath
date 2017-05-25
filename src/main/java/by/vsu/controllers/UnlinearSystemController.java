package by.vsu.controllers;

import by.vsu.calculators.UnlinearSystemCalculator;
import by.vsu.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UnlinearSystemController extends BaseController {

    private @Autowired UnlinearSystemCalculator unlinearSystemCalculator;

    @GetMapping(value = "/system-newton")
    public String systemNewton() {
        return "system-newton";
    }

    @GetMapping(value = "/system-simple-iteration")
    public String systemSimpleIteration() {
        return "system-simple-iteration";
    }

    @PostMapping(value = "/system-newton")
    public String systemNewton(@RequestParam(value = "functions") String functions,
                               @RequestParam(value = "interval") String interval,
                               @RequestParam(value = "x0") String x0,
                               @RequestParam(value = "y0") String y0,
                               @RequestParam(value = "e") Double e,
                               Model model) {
        try {
            double[] answer = this.unlinearSystemCalculator.newton(functions, interval, x0, y0, e);
            model.addAttribute("answer", "x = " + answer[0] + ", y = " + answer[1])
                    .addAttribute("drawable", false);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Упс, что-то пошло не так:( Попробуйте ещё раз!");
        }
        return "system-newton";
    }

    @PostMapping(value = "/system-simple-iteration")
    public String systemSimpleIteration(@RequestParam(value = "functions") String functions,
                                        @RequestParam(value = "interval") String interval,
                                        @RequestParam(value = "x0") String x0,
                                        @RequestParam(value = "y0") String y0,
                                        @RequestParam(value = "e") Double e,
                                        Model model) {
        try {
            double[] answer = this.unlinearSystemCalculator.simpleIteration(functions, interval, x0, y0, e);
            model.addAttribute("answer", "x = " + answer[0] + ", y = " + answer[1])
                    .addAttribute("drawable", false);
            return "answer";
        } catch (ApiException exception) {
            model.addAttribute("error", exception.getMessage());
        } catch (Exception exception) {
            model.addAttribute("error", "Упс, что-то пошло не так:( Попробуйте ещё раз!");
        }
        return "system-simple-iteration";
    }

}
