package by.vsu.core.integration;

public class SimpsonMethod extends Integration
{
    public SimpsonMethod(String func, double a, double b, double step)
    {
        super(func, a, b, step);
    }

    @Override
    public double resolve()
    {
        double sum = 0;
        double val = a + step;
        while(val < b)
        {
            function.insertValue(val);
            double v1 = function.getValue();
            function.insertValue(val-step);
            double v2 = function.getValue();
            function.insertValue(val - step * 1/2d);
            double v3 = function.getValue();
            sum += (v1 + v2 + 4 * v3);
            val += step;
        }
        return sum * step / 6;
    }


}
