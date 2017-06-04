package by.vsu.math.methods.mathphysiceq;

import by.vsu.exceptions.StabilityConditionException;
import by.vsu.analyzer.AlgebraicFunction;

class AbstractMathPhysicEquation {

    AlgebraicFunction[] boundaryConditions = new AlgebraicFunction[2];
    double a, b, a1, b1;
    double h, t;

    AbstractMathPhysicEquation(String[] boundaryConditions, double a, double b, double a1, double b1, double h, double t) {
        for (int i = 0; i < 2; i++) {
            this.boundaryConditions[i] = new AlgebraicFunction(boundaryConditions[i]);
        }
        this.a = a;
        this.b = b;
        this.a1 = a1;
        this.b1 = b1;
        this.h = h;
        this.t = t;
    }

    void fillBoundaryConditions(double[][] res, int nX, int nT) {
        for (int i = 0; i < nT; i++) {
            this.boundaryConditions[0].insertValue(this.a1 + this.t * i);
            this.boundaryConditions[1].insertValue(this.a1 + this.t * i);
            res[i][0] = this.boundaryConditions[0].getValue();
            res[i][nX - 1] = this.boundaryConditions[1].getValue();
        }
    }

    void checkStabilityCondition(double a, double b) {
        if (a > b) {
            throw new StabilityConditionException();
        }
    }

}
