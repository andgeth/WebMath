package by.vsu.calculators;

import by.vsu.core.integration.RectanglesMethod;
import by.vsu.core.integration.SimpsonMethod;
import by.vsu.core.integration.TrapezeMethod;
import by.vsu.exceptions.IllegalPointsIntervalException;
import org.springframework.stereotype.Service;

@Service
public class IntegrationCalculatorImpl implements IntegrationCalculator {

    @Override
    public double[] rectangles(String function, String interval, double h) {
        double a = Double.parseDouble(interval.split(";")[0]);
        double b = Double.parseDouble(interval.split(";")[1]);
        if (a < b) {
            return new double[] {
                    new RectanglesMethod(function, a, b, h, 'L').resolve(),
                    new RectanglesMethod(function, a, b, h, 'C').resolve(),
                    new RectanglesMethod(function, a, b, h, 'R').resolve() };
        } else {
            throw new IllegalPointsIntervalException();
        }
    }

    @Override
    public double trapeze(String function, String interval, double h) {
        double a = Double.parseDouble(interval.split(";")[0]);
        double b = Double.parseDouble(interval.split(";")[1]);
        if (a < b) {
            return new TrapezeMethod(function, a, b, h).resolve();
        } else {
            throw new IllegalPointsIntervalException();
        }
    }

    @Override
    public double simpson(String function, String interval, double h) {
        double a = Double.parseDouble(interval.split(";")[0]);
        double b = Double.parseDouble(interval.split(";")[1]);
        if (a < b) {
            return new SimpsonMethod(function, a, b, h).resolve();
        } else {
            throw new IllegalPointsIntervalException();
        }
    }
}
