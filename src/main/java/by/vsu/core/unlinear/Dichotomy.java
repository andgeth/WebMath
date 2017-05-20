package by.vsu.core.unlinear;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Dichotomy extends Unlinear {

    public Dichotomy(String str, double a, double b) {
        super(str, 0, a, b);
    }

    public double resolve(double e) {
        int iter = 0;
        f.insertValue(a);
        double val = f.getValue();
        if (val == 0) {
            return a;
        }
        f.insertValue(b);
        val = f.getValue();
        if (val == 0) {
            return b;
        }
        while (iter < 1000) {
            double x3 = (a + b) / 2;
            f.insertValue(x3);
            double cc = f.getValue();
            if (Math.abs(cc) < e) {
                return new BigDecimal(x3).setScale(this.precision, RoundingMode.DOWN).doubleValue();
            }
            f.insertValue(a);
            val = f.getValue();
            if (val * cc < 0) {
                b = x3;
            } else {
                a = x3;
            }
            iter++;
        }
        return Double.NaN;
    }

}
