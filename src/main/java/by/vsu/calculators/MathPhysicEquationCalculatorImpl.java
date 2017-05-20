package by.vsu.calculators;

import by.vsu.core.mathphysiceq.HyperbolicEquation;
import by.vsu.core.mathphysiceq.ParabolicEquation;
import by.vsu.core.math.objects.Matrix;
import org.springframework.stereotype.Service;

@Service
public class MathPhysicEquationCalculatorImpl implements MathPhysicEquationCalculator {

    @Override
    public Matrix hyperbolic(String initConditions, String boundConditions, String xInterval, String tInterval, Double hx,
                             Double ht) {
        String[] x = xInterval.split(";");
        String[] t = tInterval.split(";");
        return new HyperbolicEquation(
                initConditions.split(";"),
                boundConditions.split(";"),
                Double.valueOf(x[0]), Double.valueOf(x[1]),
                Double.valueOf(t[0]), Double.valueOf(t[1]),
                hx, ht).solve();
    }

    @Override
    public double[][] parabolic(String function, String initCondition, String boundConditions, String xInterval,
                                String tInterval, double h, double t, double weight) {
        String[] xPoints = xInterval.split(";");
        String[] tPoints = tInterval.split(";");
        return new ParabolicEquation(
                initCondition,
                boundConditions.split(";"),
                function,
                Double.valueOf(xPoints[0]), Double.valueOf(xPoints[1]),
                Double.valueOf(tPoints[0]), Double.valueOf(tPoints[1]),
                h, t).solve(weight);
    }

}
