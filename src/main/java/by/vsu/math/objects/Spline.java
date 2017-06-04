package by.vsu.math.objects;

import by.vsu.analyzer.AlgebraicFunction;
import by.vsu.exceptions.SolutionNotFoundException;

public class Spline {

    private AlgebraicFunction[] functions;
    private double[] xPoints;

    public Spline(AlgebraicFunction[] functions, double[] xPoints) {
        this.functions = functions;
        this.xPoints = xPoints;
    }

    public double getValue(double x) {
        if (x >= this.xPoints[0] && x <= this.xPoints[1]) {
            this.functions[0].insertValue(x);
            return this.functions[0].getValue();
        }
        for (int i = 1; i < this.functions.length; i++) {
            if (x > this.xPoints[i] && x <= this.xPoints[i + 1]) {
                this.functions[i].insertValue(x);
                return this.functions[i].getValue();
            }
        }
        throw new SolutionNotFoundException();
    }

}
