package by.vsu.calculators;

import by.vsu.analyzer.operators.VariableValuePair;
import by.vsu.exceptions.IllegalInitialApproximationException;
import by.vsu.exceptions.IllegalPointsIntervalException;
import by.vsu.exceptions.SolutionNotFoundException;
import by.vsu.math.methods.unlinear.*;
import org.springframework.stereotype.Service;

@Service
public class NonlinearEquationCalculatorImpl implements NonlinearEquationCalculator {

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
            double answer = new Dichotomy(function, a, b).resolve(e);
            if (!Double.isNaN(answer)) {
                return answer;
            } else {
                throw new SolutionNotFoundException();
            }
        } else {
            throw new IllegalPointsIntervalException();
        }
    }

    @Override
    public double newton(String function, String x0, double e) {
        double answer = new Newton(function, new VariableValuePair(x0)).resolve(e);
        if (!Double.isNaN(answer)) {
            return answer;
        } else {
            throw new SolutionNotFoundException();
        }
    }

    @Override
    public double secant(String function, String x1, String x2, double e) {
        double answer = new Secant(function, new VariableValuePair(x1).getValue(), new VariableValuePair(x2).getValue()).resolve(e);
        if (!Double.isNaN(answer)) {
            return answer;
        } else {
            throw new SolutionNotFoundException();
        }
    }

    @Override
    public double simpleIteration(String function, String interval, String x0, double e) {
        String[] points = interval.split(";");
        double a = Double.valueOf(points[0]);
        double b = Double.valueOf(points[1]);
        VariableValuePair pair = new VariableValuePair(x0);
        if (pair.getValue() >= a && pair.getValue() <= b) {
            if (a < b) {
                double answer = new SimpleIteration(function, pair, a, b).resolve(e);
                if (!Double.isNaN(answer)) {
                    return answer;
                } else {
                    throw new SolutionNotFoundException();
                }
            } else {
                throw new IllegalPointsIntervalException();
            }
        } else {
            throw new IllegalInitialApproximationException();
        }
    }

}
