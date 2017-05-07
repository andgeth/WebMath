package main.java.by.vsu.unlinearsys;

import main.java.by.vsu.analyzer.algebra.VariableValuePair;
import main.java.by.vsu.matrix.Matrix;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class Newton extends UnlinearSystem {
    private String[][] dependencies;

    public Newton(String[] functions, VariableValuePair[] x0) {
        super(functions, x0);
        dependencies = new String[2][];
        dependencies[0] = f[0].getDependencies().split(";");
        dependencies[1] = f[1].getDependencies().split(";");
    }

    private double[][] JacobiMatrix(VariableValuePair[] x0) {
        double[][] res = new double[number][number];
        TreeSet<String> setDependentElems = new TreeSet<>();
        Iterator<String> iterator;
        for (String[] s : dependencies) {
            setDependentElems.addAll(Arrays.asList(s));
        }
        for (int i = 0; i < number; i++) {
            f[i].insertValues(x0);
            iterator = setDependentElems.iterator();
            for (int j = 0; j < number; j++) {
                if (iterator.hasNext()) {
                    res[i][j] = f[i].getDerivativeValue(iterator.next());
                }
            }
        }
        return res;
    }

    private double[][] AMatrix(VariableValuePair[] x0, int num) {
        double[][] res = new double[number][number];
        Iterator<String> iterator;
        TreeSet<String> setDependentElements = new TreeSet<>((o1, o2) -> -o1.compareTo(o2));
        for (String[] s : dependencies) {
            setDependentElements.addAll(Arrays.asList(s));
        }
        iterator = setDependentElements.iterator();
        for (int i = 0; i < num; i++) {
            if (iterator.hasNext()) {
                iterator.next();
            }
        }
        String tmp = iterator.next();
        for (int i = 0; i < number; i++) {
            f[i].insertValues(x0);
            for (int j = 0; j < number; j++) {
                if (j == num) {
                    res[i][j] = f[i].getValue();
                } else {
                    res[i][j] = f[i].getDerivativeValue(tmp);
                }
            }
        }
        return res;
    }

    @Override
    public double[] resolve(double e) {
        Matrix J = new Matrix(JacobiMatrix(x0));
        Matrix[] A = new Matrix[number];
        for (int i = 0; i < number; i++) {
            A[i] = new Matrix(AMatrix(x0, i));
        }
        VariableValuePair[] x1 = new VariableValuePair[number];
        for (int i = 0; i < number; i++) {
            x1[i] = new VariableValuePair(x0[i]);
        }
        int iter = 0;
        while (iter < 1000) {
            for (int i = 0; i < number; i++) {
                x1[i].assign(x0[i].getValue() - A[i].Det() / J.Det());
            }
            if (maxDifference(x0, x1) <= e) {
                double[] res = new double[number];
                for (int j = 0; j < number; j++) {
                    res[j] = x1[j].getValue();
                }
                return res;
            }
            for (int i = 0; i < number; i++) {
                x0[i].assign(x1[i].getValue());
            }
            J = new Matrix(JacobiMatrix(x0));
            for (int i = 0; i < number; i++) {
                A[i] = new Matrix(AMatrix(x0, i));
            }
            iter++;
        }
        return null;
    }

}
