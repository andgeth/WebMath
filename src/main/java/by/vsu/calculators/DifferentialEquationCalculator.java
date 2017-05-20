package by.vsu.calculators;

public interface DifferentialEquationCalculator {

    double[] euler(String function, String interval, String y0, double h);
    double[] eulerCauchy(String function, String interval, String y0, double h);
    double[] betterEuler(String function, String interval, String y0, double h);
    double[] rungeKutta(String function, String interval, String y0, double h);

}
