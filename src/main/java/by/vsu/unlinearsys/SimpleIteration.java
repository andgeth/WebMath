package main.java.by.vsu.unlinearsys;

import main.java.by.vsu.analyzer.algebra.VariableValuePair;

import java.util.Arrays;

public class SimpleIteration extends UnlinearSystem {

    public SimpleIteration(String[] functions, VariableValuePair[] x0) {
        super(functions, x0);
    }

    @Override
    public double[] resolve(double e) {
        VariableValuePair[] tmpx0 = new VariableValuePair[number];
        VariableValuePair[] tmpx1 = new VariableValuePair[number];
        for (int i = 0; i < number; i++) {
            tmpx0[i] = new VariableValuePair(x0[i]);
            tmpx1[i] = new VariableValuePair(x0[i]);
        }
        int iter = 0;
        while (iter <= 1000) {
            for (int i = 0; i < number; i++) {
                String[] d = f[i].getDependencies().split(";");
                f[i].insertValues(tmpx0);
                for (int j = 0; j < number; j++) {
                    if (Arrays.binarySearch(d, tmpx0[j].getNameVariable()) < 0) {
                        tmpx1[j].assign(f[i].getValue());
                    }
                }
            }
            if (maxDifference(tmpx1, tmpx0) <= e) {
                double[] res = new double[number];
                for (int i = 0; i < number; i++) {
                    res[i] = tmpx1[i].getValue();
                }
                return res;
            }
            for (int i = 0; i < number; i++) {
                tmpx0[i].assign(tmpx1[i]);
            }
            iter++;
        }
        return null;
    }

}
