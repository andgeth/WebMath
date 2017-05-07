package main.java.by.vsu.analyzer.algebra;

public interface MathExpression {

    double calculate();
    double calculateDerivative(String nameVariable);
    String getDependencies();

}
