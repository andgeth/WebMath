package main.java.by.vsu.controllers.divideRoots;

import main.java.by.vsu.analyzer.AlgebraicFunction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GraphicDivideRoots {

    @RequestMapping(value = "/divide")
    public String graphicDivideRoots(
            @RequestParam(value = "func1", required = false) String func1,
            @RequestParam(value = "func2", required = false) String func2,
            @RequestParam(value = "interval", required = false) String interval, Model model) {
        if (func1 != null && interval != null) {
            StringBuilder strFunc1Values = new StringBuilder();
            StringBuilder strFunc2Values = new StringBuilder();
            double a = Double.parseDouble(interval.split(";")[0]);
            double b = Double.parseDouble(interval.split(";")[1]);
            AlgebraicFunction af = new AlgebraicFunction(func1);

            for (double i = a; i <= b; i += 0.5) {
                af.insertValue(i);
                strFunc1Values.append(af.getValue()).append(";");
            }
            model.addAttribute("func1val", strFunc1Values);
            if (func2 != null) {
                af = new AlgebraicFunction(func2);
                for (double i = a; i <= b; i += 0.5) {
                    af.insertValue(i);
                    strFunc2Values.append(af.getValue()).append(";");
                }
                model.addAttribute("func2val", strFunc2Values);
            }
            model.addAttribute("interval", interval);
        }
        return "divide";
    }

}