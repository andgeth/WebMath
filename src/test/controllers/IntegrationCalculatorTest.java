package controllers;

import by.vsu.calculators.IntegrationCalculator;
import by.vsu.calculators.IntegrationCalculatorImpl;
import org.junit.Test;

import java.util.Arrays;

public class IntegrationCalculatorTest {

    private IntegrationCalculator calculator = new IntegrationCalculatorImpl();
    private String function = "1/(1+x^2)";
    private String interval = "0;1";
    private double h = 0.1;

    @Test
    public void rectangles() {
        System.out.println(Arrays.toString(this.calculator.rectangles(function, interval, h)));
    }

    @Test
    public void trapeze() {
        System.out.println(this.calculator.trapeze(function, interval, h));
    }

    @Test
    public void simpson() {
        System.out.println(this.calculator.simpson(function, interval, h));
    }

}
