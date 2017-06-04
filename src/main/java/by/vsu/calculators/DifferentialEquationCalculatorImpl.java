package by.vsu.calculators;

import by.vsu.analyzer.operators.VariableValuePair;
import by.vsu.math.methods.diffeq.BetterEuler;
import by.vsu.math.methods.diffeq.Euler;
import by.vsu.math.methods.diffeq.EulerCauchy;
import by.vsu.math.methods.diffeq.RungeKutta;
import by.vsu.exceptions.IllegalPointsIntervalException;
import by.vsu.exceptions.IllegalStepValueException;
import by.vsu.exceptions.SolutionNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DifferentialEquationCalculatorImpl implements DifferentialEquationCalculator {

    @Override
    public double[] euler(String function, String interval, String y0, double h) {
        double a = Double.parseDouble(interval.split(";")[0]);
        double b = Double.parseDouble(interval.split(";")[1]);
        if (a < b) {
            if (h > 0) {
                double[] answer = new Euler(function, new VariableValuePair(y0), a, b, h).resolve();
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
    public double[] eulerCauchy(String function, String interval, String y0, double h) {
        double a = Double.parseDouble(interval.split(";")[0]);
        double b = Double.parseDouble(interval.split(";")[1]);
        if (a < b) {
            if (h > 0) {
                double[] answer = new EulerCauchy(function, new VariableValuePair(y0), a, b, h).resolve();
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
    public double[] betterEuler(String function, String interval, String y0, double h) {
        double a = Double.parseDouble(interval.split(";")[0]);
        double b = Double.parseDouble(interval.split(";")[1]);
        if (a < b) {
            if (h > 0) {
                double[] answer = new BetterEuler(function, new VariableValuePair(y0), a, b, h).resolve();
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
    public double[] rungeKutta(String function, String interval, String y0, double h) {
        double a = Double.parseDouble(interval.split(";")[0]);
        double b = Double.parseDouble(interval.split(";")[1]);
        if (a < b) {
            if (h > 0) {
                double[] answer = new RungeKutta(function, new VariableValuePair(y0), a, b, h).resolve();
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
