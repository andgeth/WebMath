package by.vsu.math.methods.unlinear;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Secant extends Unlinear {

    private double x1;

    public Secant(String str, double x0, double x1) {
        super(str, x0, -1, -1);
        this.x1 = x1;
    }

    @Override
    public double resolve(double e) {
        int iter = 0;
        f.insertValue(x0);
        double y0 = f.getValue();
        f.insertValue(x1);
        double y1 = f.getValue();
        while (iter < 1000) {
            double x2 = x1 - y1 * (x0 - x1) / (y0 - y1);
            if (Math.abs(x2 - x1) <= e) {
                return new BigDecimal(x2).setScale(this.precision, RoundingMode.DOWN).doubleValue();
            }
            x0 = x1;
            x1 = x2;
            f.insertValue(x0);
            y0 = f.getValue();
            f.insertValue(x1);
            y1 = f.getValue();
            iter++;
        }
        return Double.NaN;
    }

}
