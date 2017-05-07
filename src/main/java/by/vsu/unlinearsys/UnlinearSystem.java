package main.java.by.vsu.unlinearsys;

import main.java.by.vsu.analyzer.AlgebraicFunction;
import main.java.by.vsu.analyzer.algebra.VariableValuePair;

public abstract class UnlinearSystem {

    AlgebraicFunction[] f;
    VariableValuePair[] x0;
    int number;

    UnlinearSystem(String[] functions, VariableValuePair[] x0) {
        this.number = functions.length;
        this.x0 = new VariableValuePair[number];
        this.f = new AlgebraicFunction[number];
        for (int i = 0; i < number; i++) {
            this.f[i] = new AlgebraicFunction(functions[i]);
        }
        for (int i = 0; i < number; i++) {
            this.x0[i] = new VariableValuePair(x0[i]);
        }
    }

    double maxDifference(VariableValuePair[] a, VariableValuePair[] b) {
        double max = Math.abs(a[0].getValue() - b[0].getValue());
        for (int i = 1; i < a.length; i++) {
            if (Math.abs(a[i].getValue() - b[i].getValue()) > max) {
                max = Math.abs(a[i].getValue() - b[i].getValue());
            }
        }
        return max;
    }

    public abstract double[] resolve(double e);

}
