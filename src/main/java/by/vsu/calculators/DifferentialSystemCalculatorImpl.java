package by.vsu.calculators;

import by.vsu.analyzer.operators.VariableValuePair;
import by.vsu.math.methods.diffsys.Euler;
import by.vsu.math.methods.diffsys.RungeKutta;
import by.vsu.exceptions.IllegalPointsIntervalException;
import by.vsu.exceptions.IllegalStepValueException;
import org.springframework.stereotype.Service;

@Service
public class DifferentialSystemCalculatorImpl implements DifferentialSystemCalculator {

    @Override
    public double[][] euler(String functions, String interval, String y0, String z0, double h) {
        double a = Double.parseDouble(interval.split(";")[0]);
        double b = Double.parseDouble(interval.split(";")[1]);
        if (a < b) {
            if (h > 0) {
                return new Euler(functions.split(";"),
                        new VariableValuePair[] { new VariableValuePair(y0), new VariableValuePair(z0) }, a, b, h)
                        .resolve();
            } else {
                throw new IllegalStepValueException();
            }
        } else {
            throw new IllegalPointsIntervalException();
        }
    }

    @Override
    public double[][] rungeKutta(String functions, String interval, String y0, String z0, double h) {
        double a = Double.parseDouble(interval.split(";")[0]);
        double b = Double.parseDouble(interval.split(";")[1]);
        if (a < b) {
            if (h > 0) {
                return new RungeKutta(functions.split(";"),
                        new VariableValuePair[] { new VariableValuePair(y0), new VariableValuePair(z0) }, a, b, h)
                        .resolve();
            } else {
                throw new IllegalStepValueException();
            }
        } else {
            throw new IllegalPointsIntervalException();
        }
    }

}
