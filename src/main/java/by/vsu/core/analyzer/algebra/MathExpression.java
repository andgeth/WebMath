package by.vsu.core.analyzer.algebra;

public interface MathExpression {

    double calculate();
    double calculateDerivative(String nameVariable);
    String getDependencies();

}
