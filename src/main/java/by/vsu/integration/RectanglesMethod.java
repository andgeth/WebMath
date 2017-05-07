package main.java.by.vsu.integration;

public class RectanglesMethod extends Integration
{
    char type;

    public RectanglesMethod(String func, double a, double b, double step, char type)
    {
        super(func,a,b,step);
        this.type = type;
    }

    public double resolveL()
    {
        double sum = 0;
        double val = a;
        while(val < b - step)
        {
            function.insertValue(val);
            sum += function.getValue();
            val += step;
        }
        return sum * step;
    }

    public double resolveR()
    {
        double sum = 0;
        double val = a + step;
        while(val < b)
        {
            function.insertValue(val);
            sum += function.getValue();
            val += step;
        }
        return sum * step;
    }

    public double resolveC()
    {
        double sum = 0;
        double val = a + 1/2d * step;
        while(val < b)
        {
            function.insertValue(val);
            sum += function.getValue();
            val += step;
        }
        return sum * step;
    }

    public double resolve()
    {
        switch(type)
        {
            case 'L': return resolveL();
            case 'R': return resolveR();
            case 'C': return resolveC();
            default: return Double.NaN;
        }
    }
}
