package by.vsu.math.methods.unlinear;

import by.vsu.analyzer.AlgebraicFunction;
import by.vsu.analyzer.operators.VariableValuePair;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class SimpleIteration extends Unlinear {

    private String nameVariable;

    public SimpleIteration(String str, VariableValuePair x0, double a, double b) {
        super(str, x0.getValue(), a, b);
        nameVariable = x0.getNameVariable();
    }

    private AlgebraicFunction createGx() {
        double constForSx = -1;
        boolean pressure = true;
        AlgebraicFunction gx = new AlgebraicFunction(this.nameVariable + "+(" + this.f.getStrView() + ")*" + constForSx);
        Locale l = new Locale("en", "GB");
        for (; constForSx < 1; constForSx += 0.005) {
            for (double i = this.a; i < this.b; i += 0.1) {
                gx.insertValue(i);
                if (Math.abs(gx.getDerivativeValue(this.nameVariable)) >= 1) {
                    pressure = false;
                    break;
                }
                pressure = true;
            }
            if (pressure) {
                break;
            }
            gx = new AlgebraicFunction(this.nameVariable + "+(" + this.f.getStrView() + ")*" + String.format(l, "%f", constForSx));
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
                return new BigDecimal(x1).setScale(this.precision, RoundingMode.DOWN).doubleValue();
            } else {
                xk = x1;
            }
            iter++;
        }
        return Double.NaN;
    }

}
