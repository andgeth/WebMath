package by.vsu.math.methods.boundarytask;

import by.vsu.math.methods.linear.SweepMethod;
import by.vsu.math.objects.Matrix;
import by.vsu.math.objects.Vector;

public class NetsMethod extends BoundaryTask {

    public NetsMethod(String pstr, String qstr, String fstr, double a, double b, double h, double alpha1, double alpha2,
                        double beta1, double beta2, double gamma1, double gamma2) {
        super(pstr, qstr, fstr, a, b, h, alpha1, alpha2, beta1, beta2, gamma1, gamma2);
    }

    @Override
    public double[] resolve() {
        int n = (int) ((b - a) / h) + 1;
        double[] xes = new double[n];
        xes[0] = a;
        for (int i = 1; i < n; i++) {
            xes[i] = xes[i - 1] + h;
        }
        double[] pes = new double[n];
        double[] qes = new double[n];
        double[] fes = new double[n];
        for (int i = 0; i < n; i++) {
            px.insertValue(xes[i]);
            pes[i] = px.getValue();

            qx.insertValue(xes[i]);
            qes[i] = qx.getValue();

            fx.insertValue(xes[i]);
            fes[i] = fx.getValue();
        }
        Matrix M = new Matrix(n);
        Vector V = new Vector(n);
        M.setElement(0, 0, alpha1 - beta1 / h);
        M.setElement(0, 1, beta1 / h);
        V.setElement(0, gamma1);
        M.setElement(n - 1, n - 2, -beta2 / h);
        M.setElement(n - 1, n - 1, alpha2 + beta2 / h);
        V.setElement(n - 1, gamma2);
        for (int i = 1; i < n - 1; i++) {
            M.setElement(i, i - 1, 1 / (h * h) - pes[i] / (2 * h));
            M.setElement(i, i, -2 / (h * h) + qes[i]);
            M.setElement(i, i + 1, 1 / (h * h) + pes[i] / (2 * h));
            V.setElement(i, fes[i]);
        }
        SweepMethod sp = new SweepMethod(M, V);
        return sp.solve().getV();
    }

}
