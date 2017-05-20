package by.vsu.calculators;

public interface IntegrationCalculator {

    double[] rectangles(String function, String interval, double h);
    double trapeze(String function, String interval, double h);
    double simpson(String function, String interval, double h);

}
