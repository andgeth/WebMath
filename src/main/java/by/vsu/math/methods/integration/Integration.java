package by.vsu.math.methods.integration;

import by.vsu.analyzer.AlgebraicFunction;

public abstract class Integration
{
    AlgebraicFunction function;
    double a, b;
    double step;

    public Integration(String func, double a, double b, double step)
    {
        this.function = new AlgebraicFunction(func);
        this.a = a;
        this.b = b;
        this.step = step;
    }

    public abstract double resolve();
}
