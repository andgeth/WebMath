package by.vsu.core.unlinear;

import by.vsu.core.analyzer.algebra.VariableValuePair;

public class Newton extends Unlinear {

    private String nameVariable;

    public Newton(String str, VariableValuePair x0) {
        super(str, x0.getValue());
        nameVariable = x0.getNameVariable();
    }

    public double resolve(double e) {
        int iter = 0;
        double x0 = this.x0;
        while (iter < 1000) {
            f.insertValue(x0);
            double v = f.getValue();
            double d = f.getDerivativeValue(nameVariable);
            double x1 = x0 - v / d;
            if (Math.abs(x1 - x0) <= e) {
                return x1;
            }
            x0 = x1;
            iter++;
        }
        return Double.NaN;
    }

}
