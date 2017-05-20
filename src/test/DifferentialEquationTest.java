import by.vsu.calculators.DifferentialEquationCalculator;
import by.vsu.calculators.DifferentialEquationCalculatorImpl;
import org.junit.Test;

import java.util.Arrays;

public class DifferentialEquationTest {

    private DifferentialEquationCalculator calculator = new DifferentialEquationCalculatorImpl();
    private String function = "x+cos(y/PI)";
    private String interval = "1.7;2.7";
    private String y0 = "y=5.3";
    private double h = 0.1;

    @Test
    public void euler() {
        System.out.println(Arrays.toString(calculator.euler(function, interval, y0, h)));
    }

    @Test
    public void eulerCauchy() {
        System.out.println(Arrays.toString(calculator.eulerCauchy(function, interval, y0, h)));
    }

    @Test
    public void betterEuler() {
        System.out.println(Arrays.toString(calculator.betterEuler(function, interval, y0, h)));
    }

    @Test
    public void rungeKutta() {
        System.out.println(Arrays.toString(calculator.rungeKutta(function, interval, y0, h)));
    }

}
