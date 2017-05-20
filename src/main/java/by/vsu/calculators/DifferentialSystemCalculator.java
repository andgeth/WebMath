package by.vsu.calculators;

public interface DifferentialSystemCalculator {

    double[][] euler(String functions, String interval, String y0, String z0, double h);
    double[][] rungeKutta(String functions, String interval, String y0, String z0, double h);

}
