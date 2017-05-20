package by.vsu.calculators;

import by.vsu.core.boundarytask.NetsMethod;
import by.vsu.core.boundarytask.ReductionMethod;
import by.vsu.core.boundarytask.ShootMethod;
import by.vsu.exceptions.IllegalPointsIntervalException;
import by.vsu.exceptions.IllegalStepValueException;
import by.vsu.exceptions.SolutionNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BoundaryTaskCalculatorImpl implements BoundaryTaskCalculator {

    @Override
    public double[] nets(String functions, String startCondition, String endCondition, String interval, double h) {
        String[] arrFunctions = functions.split(";");
        String[] arrStartCondition = startCondition.split(";");
        String[] arrEndCondition = endCondition.split(";");
        String[] points = interval.split(";");
        double a = Double.parseDouble(points[0]);
        double b = Double.parseDouble(points[1]);
        if (a < b) {
            if (h > 0) {
                NetsMethod netsMethod = new NetsMethod(arrFunctions[0], arrFunctions[1], arrFunctions[2], a, b, h, Double.valueOf(arrStartCondition[0]), Double.valueOf(arrEndCondition[0]), Double.valueOf(arrStartCondition[1]), Double.valueOf(arrEndCondition[1]), Double.valueOf(arrStartCondition[2]), Double.valueOf(arrEndCondition[2]));
                double[] answer = netsMethod.resolve();
                if (answer != null) {
                    return answer;
                } else {
                    throw new SolutionNotFoundException();
                }
            } else {
                throw new IllegalStepValueException();
            }
        } else {
            throw new IllegalPointsIntervalException();
        }
    }

    @Override
    public double[] reduction(String functions, String startCondition, String endCondition, String interval, double h) {
        String[] arrFunctions = functions.split(";");
        String[] arrStartCondition = startCondition.split(";");
        String[] arrEndCondition = endCondition.split(";");
        String[] points = interval.split(";");
        double a = Double.parseDouble(points[0]);
        double b = Double.parseDouble(points[1]);
        if (a < b) {
            if (h > 0) {
                ReductionMethod reduction = new ReductionMethod(arrFunctions[0], arrFunctions[1], arrFunctions[2], a, b, h, Double.valueOf(arrStartCondition[0]), Double.valueOf(arrEndCondition[0]), Double.valueOf(arrStartCondition[1]), Double.valueOf(arrEndCondition[1]), Double.valueOf(arrStartCondition[2]), Double.valueOf(arrEndCondition[2]));
                double[] answer = reduction.resolve();
                if (answer != null) {
                    return answer;
                } else {
                    throw new SolutionNotFoundException();
                }
            } else {
                throw new IllegalStepValueException();
            }
        } else {
            throw new IllegalPointsIntervalException();
        }
    }

    @Override
    public double[] shoot(String functions, String startCondition, String endCondition, String shootingAngles, double initialValue,
                          String interval, double h, double e) {
        String[] arrFunctions = functions.split(";");
        String[] arrStartCondition = startCondition.split(";");
        String[] arrEndCondition = endCondition.split(";");
        String[] arrShootAngles = shootingAngles.split(";");
        String[] points = interval.split(";");
        double a = Double.parseDouble(points[0]);
        double b = Double.parseDouble(points[1]);
        if (a < b) {
            if (h > 0) {
                ShootMethod shoot = new ShootMethod(
                        arrFunctions[0], arrFunctions[1], arrFunctions[2],
                        a, b, h,
                        Double.valueOf(arrStartCondition[0]), Double.valueOf(arrEndCondition[0]),
                        Double.valueOf(arrStartCondition[1]), Double.valueOf(arrEndCondition[1]),
                        Double.valueOf(arrStartCondition[2]), Double.valueOf(arrEndCondition[2]));
                shoot.setShootingAngles(new double[]{ Double.valueOf(arrShootAngles[0]), Double.valueOf(arrShootAngles[1]) });
                shoot.setInitialValues(initialValue);
                shoot.setPrecision(e);
                double[] answer = shoot.resolve();
                if (answer != null) {
                    return answer;
                } else {
                    throw new SolutionNotFoundException();
                }
            } else {
                throw new IllegalStepValueException();
            }
        } else {
            throw new IllegalPointsIntervalException();
        }
    }

}
