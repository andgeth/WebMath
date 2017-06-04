package by.vsu.analyzer.operators;

public interface MathExpression {

    double calculate();
    double calculateDerivative(String nameVariable);
    String getDependencies();

}
