package by.vsu.calculators;

public interface MathPhysicEquationCalculator {

    double[][] elliptic(String xInterval, String tInterval, String boundConditions, double h, double e);
    double[][] hyperbolic(String initConditions, String boundConditions, String xInterval, String tInterval, Double hx, Double ht);
    double[][] parabolic(String function, String initCondition, String boundConditions, String xInterval, String tInterval,
                         double h, double t, double weight);
}
