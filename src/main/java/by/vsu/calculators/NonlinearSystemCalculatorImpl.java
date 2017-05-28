package by.vsu.calculators;

import by.vsu.core.analyzer.algebra.VariableValuePair;
import by.vsu.core.unlinearsys.Newton;
import by.vsu.core.unlinearsys.SimpleIteration;
import by.vsu.exceptions.IllegalPointsIntervalException;
import by.vsu.exceptions.SolutionNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class NonlinearSystemCalculatorImpl implements NonlinearSystemCalculator {

    @Override
    public double[] newton(String functions, String interval, String x0, String y0, double e) {
        String[] points = interval.split(";");
        double a = Double.valueOf(points[0]);
        double b = Double.valueOf(points[1]);
        VariableValuePair[] initApproximation = { new VariableValuePair(x0), new VariableValuePair(y0) };
        if (a < b) {
            double[] answer = new Newton(functions.split(";"), initApproximation).resolve(e);
            if (answer != null) {
                return answer;
            } else {
                throw new SolutionNotFoundException();
            }
        } else {
            throw new IllegalPointsIntervalException();
        }
    }

    @Override
    public double[] simpleIteration(String functions, String interval, String x0, String y0, double e) {
        String[] points = interval.split(";");
        double a = Double.valueOf(points[0]);
        double b = Double.valueOf(points[1]);
        VariableValuePair[] initApproximation = { new VariableValuePair(x0), new VariableValuePair(y0) };
        if (a < b) {
            double[] answer = new SimpleIteration(functions.split(";"), initApproximation).resolve(e);
            if (answer != null) {
                return answer;
            } else {
                throw new SolutionNotFoundException();
            }
        } else {
            throw new IllegalPointsIntervalException();
        }
    }

}
