package by.vsu.core.diffsys;

import by.vsu.core.analyzer.AlgebraicFunction;
import by.vsu.core.analyzer.algebra.VariableValuePair;

public abstract class SystemsDiffEquations {

    AlgebraicFunction[] f;
    VariableValuePair[] initialValues;
    double[] net;
    double a, b;
    double h;

    public void setInitialValue(int index, double val) {
        if (index >= initialValues.length) {
            return;
        }
        this.initialValues[index].assign(val);
    }

    public SystemsDiffEquations(String[] functions, VariableValuePair[] pair, double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
        f = new AlgebraicFunction[functions.length];
        initialValues = new VariableValuePair[functions.length + 1];
        for (int i = 0; i < functions.length; i++) {
            f[i] = new AlgebraicFunction(functions[i]);
            initialValues[i + 1] = new VariableValuePair(pair[i]);
        }
        String[][] dependsOn = { f[0].getDependencies().split(";"), f[1].getDependencies().split(";") };
        String nameIndependVariable = null;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < dependsOn[i].length; j++) {
                if (!dependsOn[i][j].equals(initialValues[1].getNameVariable()) && !dependsOn[i][j].equals(initialValues[2].getNameVariable())) {
                    nameIndependVariable = dependsOn[i][j];
                    break;
                }
            }
            if (nameIndependVariable != null) {
                break;
            }
        }
        initialValues[0] = new VariableValuePair(nameIndependVariable, a);
        net = new double[(int) ((b - a) / h) + 1];
        net[0] = a;
        for (int i = 1; i < net.length; i++) {
            this.net[i] = this.net[i - 1] + this.h;
        }
    }

    public abstract double[][] resolve();

}
