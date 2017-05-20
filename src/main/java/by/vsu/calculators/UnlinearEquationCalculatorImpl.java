package by.vsu.calculators;

import by.vsu.core.analyzer.algebra.VariableValuePair;
import by.vsu.core.unlinear.*;
import by.vsu.exceptions.IllegalInitialApproximationException;
import by.vsu.exceptions.IllegalPointsIntervalException;
import org.springframework.stereotype.Service;

@Service
public class UnlinearEquationCalculatorImpl implements UnlinearEquationCalculator {

    @Override
    public double chord(String function, String x1, String x2, double e) {
        return new Chord(function, new VariableValuePair(x1).getValue(), new VariableValuePair(x2).getValue()).resolve(e);
    }

    @Override
    public double dichotomy(String function, String interval, double e) {
        String[] points = interval.split(";");
        double a = Double.valueOf(points[0]);
        double b = Double.valueOf(points[1]);
        if (a < b) {
            return new Dichotomy(function, a, b).resolve(e);
        } else {
            throw new IllegalPointsIntervalException();
        }
    }

    @Override
    public double newton(String function, String x0, double e) {
        return new Newton(function, new VariableValuePair(x0)).resolve(e);
    }

    @Override
    public double secant(String function, String x1, String x2, double e) {
        return new Secant(function, new VariableValuePair(x1).getValue(), new VariableValuePair(x2).getValue()).resolve(e);
    }

    @Override
    public double simpleIteration(String function, String interval, String x0, double e) {
        String[] points = interval.split(";");
        double a = Double.valueOf(points[0]);
        double b = Double.valueOf(points[1]);
        VariableValuePair pair = new VariableValuePair(x0);
        if (pair.getValue() >= a && pair.getValue() <= b) {
            if (a < b) {
                return new SimpleIteration(function, pair, a, b).resolve(e);
            } else {
                throw new IllegalPointsIntervalException();
            }
        } else {
            throw new IllegalInitialApproximationException();
        }
    }

}
