package main.java.by.vsu.integration;

public class TrapezeMethod extends Integration
{
    public TrapezeMethod(String func, double a, double b, double step)
    {
        super(func,a,b,step);
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
            function.insertValue(val - step);
            double v2 = function.getValue();
            sum += (v1 + v2) / 2;
            val += step;
        }
        return sum * step;
    }
}
