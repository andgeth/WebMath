package by.vsu.calculators;

public interface BoundaryTaskCalculator {

    double[] nets(String functions, String startCondition, String endCondition, String interval, double h);
    double[] reduction(String functions, String startCondition, String endCondition, String interval, double h);
    double[] shoot(String functions, String startCondition, String endCondition, String shootingAngles, double initialValue,
                   String interval, double h, double e);

}
