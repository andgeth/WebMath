package by.vsu.calculators;

public interface MathPhysicEquationCalculator {

    double[][] hyperbolic(String initConditions, String boundConditions, String xInterval, String tInterval, Double hx, Double ht);
    double[][] parabolic(String function, String initCondition, String boundConditions, String xInterval, String tInterval,
                         double h, double t, double weight);
}
