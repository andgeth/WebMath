package by.vsu.calculators;

public interface NonlinearEquationCalculator {

    double chord(String function, String x1, String x2, double e);
    double dichotomy(String function, String interval, double e);
    double newton(String function, String x0, double e);
    double secant(String function, String x1, String x2, double e);
    double simpleIteration(String function, String interval, String x0, double e);

}
