package by.vsu.core.mathphysiceq;

import by.vsu.exceptions.StabilityConditionException;
import by.vsu.core.analyzer.AlgebraicFunction;

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
            boundaryConditions[0].insertValue(a1 + t * i);
            boundaryConditions[1].insertValue(a1 + t * i);
            res[i][0] = boundaryConditions[0].getValue();
            res[i][nX - 1] = boundaryConditions[1].getValue();
        }
    }

    void checkStabilityCondition(double a, double b) {
        if (a > b) {
            throw new StabilityConditionException();
        }
    }

}
