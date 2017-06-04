package by.vsu.math.methods.mathphysiceq.ellipticequation;

import by.vsu.analyzer.AlgebraicFunction;
import by.vsu.math.objects.Matrix;

public class SimpleGeometry {

    private double a1, a2, b1, b2;
    private double h;
    private double precision;
    private AlgebraicFunction[] boundaryConditions = new AlgebraicFunction[4];

    public SimpleGeometry(double a1, double b1, double a2, double b2, String[] boundaryConditions, double h, double precision) {
        this.a1 = a1;
        this.a2 = a2;
        this.b1 = b1;
        this.b2 = b2;
        for (int i = 0; i < 4; i++) {
            this.boundaryConditions[i] = new AlgebraicFunction(boundaryConditions[i]);
        }
        this.h = h;
        this.precision = precision;
    }

    public double[][] solve() {
        int n1 = (int) ((b1 - a1) / h) + 1;
        int n2 = (int) ((b2 - a2) / h) + 1;
        Matrix res0 = new Matrix(n1, n2);
        Matrix res1;
        for (int i = 0; i < n1; i++) {
            double val = h * i;
            this.boundaryConditions[0].insertValue(val);
            res0.setElement(i, 0, this.boundaryConditions[0].getValue());
            this.boundaryConditions[1].insertValue(val);
            res0.setElement(n1 - 1, i, this.boundaryConditions[1].getValue());
            this.boundaryConditions[2].insertValue(val);
            res0.setElement(i, n2 - 1, this.boundaryConditions[2].getValue());
            this.boundaryConditions[3].insertValue(val);
            res0.setElement(0, i, this.boundaryConditions[3].getValue());
        }
        res1 = new Matrix(res0);
        while (true) {
            for (int i = 1; i < n1 - 1; i++) {
                for (int j = 1; j < n2 - 1; j++) {
                    res0.setElement(i, j, 1 / 4d * (res0.getElement(i - 1, j) + res0.getElement(i + 1, j) + res0.getElement(i, j - 1) + res0.getElement(i, j + 1)));
                }
            }
            double d = Matrix.Difference(res1, res0).cubicNorm();
            if (d <= this.precision) {
                return res1.toArray();
            }
            res1 = new Matrix(res0);
        }
    }

}
