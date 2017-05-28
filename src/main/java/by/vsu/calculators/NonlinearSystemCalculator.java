package by.vsu.calculators;

public interface NonlinearSystemCalculator {

    double[] newton(String functions, String interval, String x0, String y0, double e);
    double[] simpleIteration(String functions, String interval, String x0, String y0, double e);

}
