package main.java.by.vsu.controllers.unlinearsys;

import main.java.by.vsu.analyzer.AlgebraicFunction;
import main.java.by.vsu.analyzer.algebra.VariableValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import main.java.by.vsu.unlinearsys.Newton;
import main.java.by.vsu.unlinearsys.SimpleIteration;

import java.util.Arrays;

@Controller
public class UnlinearSystemController
{
    double a, b;
    double h;
    int n;
    double[] x;
    double[][] y;

    Model buildModel(String functions, String interval, String x0, String y0, Double e, Model model)
    {
        model.addAttribute("functions", functions);
        model.addAttribute("interval", interval);
        model.addAttribute("x0", x0);
        model.addAttribute("y0", y0);
        model.addAttribute("e", e);

        a = Double.parseDouble(interval.split(";")[0]);
        b = Double.parseDouble(interval.split(";")[1]);
        h = (b - a) / 20;
        n = (int)((b - a) / h) + 1;
        return model;
    }

    void calculatePoints(AlgebraicFunction[] af)
    {
        x = new double[n];
        y = new double[2][n];
        int k = 0;
        for(double i = a; i <= b; i += h)
        {
            af[0].insertValue(i);
            af[1].insertValue(i);
            x[k] = i;
            y[0][k] = af[0].getValue();
            y[1][k++] = af[1].getValue();
        }
    }

    void reset(Model model)
    {
        model.addAttribute("functions", "");
        model.addAttribute("interval", "");
        model.addAttribute("x0", "");
        model.addAttribute("y0", "");
        model.addAttribute("e", "");
    }

    @RequestMapping(value = "/systemNewton")
    public String systemNewton(
            @RequestParam(value = "functions", required = false) String functions,
            @RequestParam(value = "interval", required = false) String interval,
            @RequestParam(value = "x0", required = false) String x0,
            @RequestParam(value = "y0", required = false) String y0,
            @RequestParam(value = "e", required = false) Double e,
            Model model)
    {
        if (functions != null)
        {
            buildModel(functions, interval, x0, y0, e, model);
            if(a > b)
                model.addAttribute("answer",
                        "Введены неверные координаты отрезков!");
            else
            {
                String[] f = functions.split(";");
                VariableValuePair[] vvp = { new VariableValuePair(x0),
                        new VariableValuePair(y0) };
                Newton newton = new Newton(f, vvp);
                AlgebraicFunction[] af = { new AlgebraicFunction(f[0]),
                        new AlgebraicFunction(f[1]) };
                double[] resolve = newton.resolve(e);
                calculatePoints(af);
                if(resolve != null)
                {
                    model.addAttribute("answer",
                            resolve[0] + ", " + resolve[1]);
                    return "answer";
                }
                else
                    model.addAttribute("answer",
                            "Нет решения на данном отрезке!");
            }
        }
        return "systemNewton";
    }

    @RequestMapping(value = "/systemSimpleIteration")
    public String systemSimpleIteration(
            @RequestParam(value = "functions", required = false) String functions,
            @RequestParam(value = "interval", required = false) String interval,
            @RequestParam(value = "x0", required = false) String x0,
            @RequestParam(value = "y0", required = false) String y0,
            @RequestParam(value = "e", required = false) Double e,
            Model model)
    {
        if (functions != null)
        {
            buildModel(functions, interval, x0, y0, e, model);
            if(a > b)
                model.addAttribute("answer",
                        "Введены неверные координаты отрезков!");
            else
            {
                String[] f = functions.split(";");
                VariableValuePair[] vvp = { new VariableValuePair(x0),
                        new VariableValuePair(y0) };
                SimpleIteration simpleIteration = new SimpleIteration(f, vvp);
                AlgebraicFunction[] af = { new AlgebraicFunction(f[0]),
                        new AlgebraicFunction(f[1]) };
                double[] resolve = simpleIteration.resolve(e);
                calculatePoints(af);
                model.addAttribute("y", Arrays.toString(y[0]));
                model.addAttribute("y1", Arrays.toString(y[1]));
                model.addAttribute("x", Arrays.toString(x));
                if(resolve != null)
                {
                    model.addAttribute("answer",
                            resolve[0] + ", " + resolve[1]);
                    return "answer";
                }
                else
                    model.addAttribute("answer",
                            "Нет решения на данном отрезке!");
            }
        }
        return "systemSimpleIteration";
    }

    @RequestMapping(value = "/systemSimpleIterationReset")
    public String systemSimpleIterationReset(Model model)
    {
        reset(model);
        return "systemSimpleIteration";
    }

    @RequestMapping(value = "/systemNewtonReset")
    public String systemNewtonReset(Model model)
    {
        reset(model);
        return "systemNewton";
    }
}
