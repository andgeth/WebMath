package by.vsu.core.boundarytask;

import by.vsu.core.analyzer.algebra.VariableValuePair;
import by.vsu.core.diffsys.RungeKutta;

public class ShootMethod extends BoundaryTask {

    private double[] shootingAngles;
    private double initialValue;
    private double precision;

    public ShootMethod(String pstr, String qstr, String fstr, double a, double b, double h, double alpha1, double alpha2,
                        double beta1, double beta2, double gamma1, double gamma2) {
        super(pstr, qstr, fstr, a, b, h, alpha1, alpha2, beta1, beta2, gamma1, gamma2);
        shootingAngles = new double[2];
    }

    public void setShootingAngles(double[] val) {
        shootingAngles[0] = val[0];
        shootingAngles[1] = val[1];
    }

    public void setInitialValues(double val) {
        initialValue = val;
    }

    public void setPrecision(double val) {
        if (val >= 0) {
            precision = val;
        }
    }

    @Override
    public double[] resolve() {
        int n = (int) ((b - a) / h) + 1;
        String[] fstr = {"sx", fx.getStrView() + "-sx*(" + px.getStrView() + ")-yx*(" + qx.getStrView() + ")"};
        VariableValuePair[] pair = {
                new VariableValuePair("yx", initialValue),
                new VariableValuePair("sx", shootingAngles[0])
        };
        RungeKutta rungeKutta = new RungeKutta(fstr, pair, a, b, h);
        double[][] res1 = rungeKutta.resolve();
        rungeKutta.setInitialValue(2, shootingAngles[1]);
        double[][] res2 = rungeKutta.resolve();
        double y0 = alpha2 * res1[0][n - 1] + beta2 * res1[1][n - 1] - gamma2,
                y1 = alpha2 * res2[0][n - 1] + beta2 * res2[1][n - 1] - gamma2,
                y2;
        if (Math.abs(y0) <= precision) {
            return res1[0];
        }
        if (Math.abs(y1) <= precision) {
            return res2[0];
        }
        if (y0 * y1 < 0) {
            int iter = 0;
            double a = shootingAngles[0], b = shootingAngles[1];
            while (iter < 1000) {
                double a0 = (a + b) / 2;
                pair[1].assign(a0);
                rungeKutta.setInitialValue(2, a0);
                res1 = rungeKutta.resolve();
                double y21 = alpha2 * res1[0][n - 1];
                double y22 = gamma2 - beta2 * res1[1][n - 1];
                y2 = y21 - y22;
                if (Math.abs(y2) < precision) {
                    return res1[0];
                }
                if (y0 * y2 < 0) {
                    b = a0;
                    y1 = y2;
                } else if (y1 * y2 < 0) {
                    a = a0;
                    y0 = y2;
                }
                iter++;
            }
        }
        return null;
    }

}