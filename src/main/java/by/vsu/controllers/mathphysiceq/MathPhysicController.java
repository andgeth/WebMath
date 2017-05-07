package main.java.by.vsu.controllers.mathphysiceq;

import main.java.by.vsu.mathphysiceq.HyperbolicEquation;
import main.java.by.vsu.mathphysiceq.ParabolicEquation;
import main.java.by.vsu.mathphysiceq.ellipticequation.SimpleGeometry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Locale;

@Controller
public class MathPhysicController {

    private String toString(double[][] arr) {
        Locale l = new Locale("en", "GB");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append("[");
            for (int j = 0; j < arr[i].length - 1; j++) {
                sb.append(String.format(l, "%.5f, ", arr[i][j]));
            }
            sb.append(String.format(l, "%.5f],<p style='margin: 0 0 0 0;'>, ", arr[i][arr[i].length - 1]));
        }
        return sb.toString();
    }

    @RequestMapping("ellipticEq")
    public String elliptic(
            @RequestParam(value = "boundaryConditions", required = false) String boundaryConditions,
            @RequestParam(value = "intervalx", required = false) String intervalx,
            @RequestParam(value = "intervalt", required = false) String intervalt,
            @RequestParam(value = "h", required = false) Double h,
            @RequestParam(value = "precision", required = false) Double precision, Model model) {
        if (boundaryConditions != null) {
            double a = Double.parseDouble(intervalx.split(";")[0]);
            double b = Double.parseDouble(intervalx.split(";")[1]);
            double a1 = Double.parseDouble(intervalt.split(";")[0]);
            double b1 = Double.parseDouble(intervalt.split(";")[1]);
            String[] boundCondit = boundaryConditions.split(";");
            SimpleGeometry simpleGeometry = new SimpleGeometry(a, b, a1, b1, boundCondit, h, precision);
            double[][] solve = simpleGeometry.solve().getM();
            model.addAttribute("answer", toString(solve));
            return "answer";
        }
        return "ellipticEq";
    }

    @RequestMapping("parabolicEq")
    public String parabolic(
            @RequestParam(value = "function", required = false) String function,
            @RequestParam(value = "initialCondition", required = false) String initialCondition,
            @RequestParam(value = "boundaryConditions", required = false) String boundaryConditions,
            @RequestParam(value = "intervalx", required = false) String intervalx,
            @RequestParam(value = "intervalt", required = false) String intervalt,
            @RequestParam(value = "hx", required = false) Double hx,
            @RequestParam(value = "ht", required = false) Double ht,
            @RequestParam(value = "weight", required = false) Double weight, Model model) {
        if (function != null) {
            double a = Double.parseDouble(intervalx.split(";")[0]);
            double b = Double.parseDouble(intervalx.split(";")[1]);
            double a1 = Double.parseDouble(intervalt.split(";")[0]);
            double b1 = Double.parseDouble(intervalt.split(";")[1]);
            String[] boundCondit = boundaryConditions.split(";");
            String[] x = intervalx.split(";");
            String[] t = intervalt.split(";");
            ParabolicEquation parabolicEquation = new ParabolicEquation(initialCondition, boundCondit, function, a, b, a1, b1, hx, ht);
            double[][] solve = parabolicEquation.solve(weight).getM();
            model.addAttribute("answer", toString(solve));
            return "answer";
        }
        return "parabolicEq";
    }

    @RequestMapping("hyperbolicEq")
    public String hyperbolic(
            @RequestParam(value = "initialConditions", required = false) String initialConditions,
            @RequestParam(value = "boundaryConditions", required = false) String boundaryConditions,
            @RequestParam(value = "intervalx", required = false) String intervalx,
            @RequestParam(value = "intervalt", required = false) String intervalt,
            @RequestParam(value = "hx", required = false) Double hx,
            @RequestParam(value = "ht", required = false) Double ht, Model model) {
        if (initialConditions != null && boundaryConditions != null) {
            String[] x = intervalx.split(";");
            String[] t = intervalt.split(";");
            HyperbolicEquation hyperbolicEquation = new HyperbolicEquation(initialConditions.split(";"), boundaryConditions.split(";"), "3", Double.valueOf(x[0]), Double.valueOf(x[1]), Double.valueOf(t[0]), Double.valueOf(t[1]), hx, ht);
            double[][] solve = hyperbolicEquation.solve().getM();
            model.addAttribute("answer", toString(solve));
            return "answer";
        }
        return "hyperbolicEq";
    }

}
