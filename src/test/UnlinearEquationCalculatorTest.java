import by.vsu.calculators.NonlinearEquationCalculator;
import by.vsu.calculators.NonlinearEquationCalculatorImpl;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class UnlinearEquationCalculatorTest {

    private NonlinearEquationCalculator calculator = new NonlinearEquationCalculatorImpl();
    private String function = "(x+20)^2";
    private String interval = "-40;30";
    private String x = "x=-10";
    private String x1 = "x1=0";
    private String x2 = "x2=3";

    @Test
    public void dichotomy() {
        assertEquals(2.0, calculator.dichotomy(function, interval, 0.001));
    }

    @Test
    public void chord() {
        assertEquals(2.0, calculator.chord(function, x1, x2, 0.001));
    }

    @Test
    public void newton() {
        assertEquals(2.0, calculator.newton(function, x, 0.000000000000001));
    }

    @Test
    public void secant() {
        assertEquals(2.0, calculator.secant(function, x1, x2, 0.0000000001));
    }

    @Test
    public void simpleIteration() {
        assertEquals(2.0, calculator.simpleIteration(function, interval, x, 0.00000000001));
    }

}
