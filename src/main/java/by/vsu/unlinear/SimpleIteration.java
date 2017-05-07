package main.java.by.vsu.unlinear;

import main.java.by.vsu.analyzer.AlgebraicFunction;
import main.java.by.vsu.analyzer.algebra.VariableValuePair;
import java.util.Locale;

public class SimpleIteration extends Unlinear {

    private String nameVariable;

    public SimpleIteration(String str, VariableValuePair x0, double a, double b) {
        super(str, x0.getValue(), a, b);
        nameVariable = x0.getNameVariable();
    }

    private AlgebraicFunction createGx() {
        double ConstForSx = -1;
        boolean pressure = true;
        AlgebraicFunction gx = new AlgebraicFunction(nameVariable + "+(" + this.f.getStrView() + ")*" + ConstForSx);
        Locale l = new Locale("en", "GB");
        for (; ConstForSx < 1; ConstForSx += 0.005) {
            for (double i = this.a; i < this.b; i += 0.1) {
                gx.insertValue(i);
                if (Math.abs(gx.getDerivativeValue(nameVariable)) >= 1) {
                    pressure = false;
                    break;
                }
                pressure = true;
            }
            if (pressure) {
                break;
            }
            gx = new AlgebraicFunction(nameVariable + "+(" + this.f.getStrView() + ")*" + String.format(l, "%f", ConstForSx));
        }
        return gx;
    }

    @Override
    public double resolve(double e) {
        AlgebraicFunction gx = createGx();
        int iter = 0;
        double xk = this.x0;
        while (iter < 1000) {
            gx.insertValue(xk);
            double x1 = gx.getValue();
            if (Math.abs(xk - x1) <= e * Math.abs(this.x0 - x1)) {
                return x1;
            } else {
                xk = x1;
            }
            iter++;
        }
        return Double.NaN;
    }

}
