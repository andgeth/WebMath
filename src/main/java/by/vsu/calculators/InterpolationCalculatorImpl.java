package by.vsu.calculators;

import by.vsu.analyzer.AlgebraicFunction;
import by.vsu.math.methods.interpolating.Lagrange;
import by.vsu.math.methods.interpolating.Newton;
import by.vsu.math.methods.interpolating.SplineInterpolating;
import by.vsu.math.objects.Spline;
import org.springframework.stereotype.Service;

@Service
public class InterpolationCalculatorImpl implements InterpolationCalculator {

    @Override
    public double newton(String xValues, String yValues, String strPoints, double x) {
        String[] tmp_x = xValues.split(",");
        String[] tmp_y = yValues.split(",");
        double[] xPoints = new double[tmp_x.length];
        double[] yPoints = new double[tmp_y.length];
        for (int i = 0; i < tmp_x.length; i++) {
            xPoints[i] = Double.parseDouble(tmp_x[i]);
            yPoints[i] = Double.parseDouble(tmp_y[i]);
        }
        AlgebraicFunction result = new Newton(xPoints, yPoints, strPoints.split(";")).interpolate();
        result.insertValue(x);
        return result.getValue();
    }

    @Override
    public double lagrange(String xValues, String yValues, String strPoints, double x) {
        String[] tmp_x = xValues.split(",");
        String[] tmp_y = yValues.split(",");
        double[] xPoints = new double[tmp_x.length];
        double[] yPoints = new double[tmp_y.length];
        for (int i = 0; i < tmp_x.length; i++) {
            xPoints[i] = Double.parseDouble(tmp_x[i]);
            yPoints[i] = Double.parseDouble(tmp_y[i]);
        }
        AlgebraicFunction result = new Lagrange(xPoints, yPoints, strPoints.split(";")).interpolate();
        result.insertValue(x);
        return result.getValue();
    }

    @Override
    public Spline spline(String xValues, String yValues, double x) {
        String[] tmp_x = xValues.split(",");
        String[] tmp_y = yValues.split(",");
        double[] xPoints = new double[tmp_x.length];
        double[] yPoints = new double[tmp_y.length];
        for (int i = 0; i < tmp_x.length; i++) {
            xPoints[i] = Double.parseDouble(tmp_x[i]);
            yPoints[i] = Double.parseDouble(tmp_y[i]);
        }
        return new SplineInterpolating(xPoints, yPoints).createSpline();
    }

}
