package by.vsu.core.unlinearsys;

import by.vsu.core.analyzer.algebra.VariableValuePair;

import java.util.Arrays;

public class SimpleIteration extends UnlinearSystem {

    public SimpleIteration(String[] functions, VariableValuePair[] x0) {
        super(functions, x0);
    }

    @Override
    public double[] resolve(double e) {
        VariableValuePair[] tmpx0 = new VariableValuePair[this.number];
        VariableValuePair[] tmpx1 = new VariableValuePair[this.number];
        for (int i = 0; i < this.number; i++) {
            tmpx0[i] = new VariableValuePair(this.x0[i]);
            tmpx1[i] = new VariableValuePair(this.x0[i]);
        }
        int iter = 0;
        while (iter <= 1000) {
            for (int i = 0; i < this.number; i++) {
                String[] d = this.f[i].getDependencies().split(";");
                this.f[i].insertValues(tmpx0);
                for (int j = 0; j < this.number; j++) {
                    if (Arrays.binarySearch(d, tmpx0[j].getNameVariable()) < 0) {
                        tmpx1[j].assign(this.f[i].getValue());
                    }
                }
            }
            if (maxDifference(tmpx1, tmpx0) <= e) {
                double[] res = new double[this.number];
                for (int i = 0; i < this.number; i++) {
                    res[i] = tmpx1[i].getValue();
                }
                return res;
            }
            for (int i = 0; i < this.number; i++) {
                tmpx0[i].assign(tmpx1[i]);
            }
            iter++;
        }
        return null;
    }

}
