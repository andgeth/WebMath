package by.vsu.math.methods.diffsys;

import by.vsu.analyzer.operators.VariableValuePair;

public class Euler extends SystemsDiffEquations {

    public Euler(String[] fstr, VariableValuePair[] pair, double a, double b, double h) {
        super(fstr, pair, a, b, h);
    }

    @Override
    public double[][] resolve() {
        int n = (int) ((b - a) / h) + 1;
        double[][] yes = new double[f.length][n];
        for (int i = 0; i < f.length; i++) {
            yes[i][0] = initialValues[i + 1].getValue();
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < f.length; i++) {
                f[i].insertValues(initialValues);
                yes[i][j] = yes[i][j - 1] + h * f[i].getValue();
            }
            initialValues[0].assign(initialValues[0].getValue() + h);
            initialValues[1].assign(yes[0][j]);
            initialValues[2].assign(yes[1][j]);
        }
        return yes;
    }

}
