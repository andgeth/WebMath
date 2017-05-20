package by.vsu.calculators;

import by.vsu.core.math.objects.Spline;

public interface InterpolationCalculator {

    double newton(String xValues, String yValues, String strPoints, double x);
    double lagrange(String xValues, String yValues, String strPoints, double x);
    Spline spline(String xValues, String yValues, double x);

}
