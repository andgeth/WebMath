import by.vsu.calculators.NonlinearSystemCalculator;
import by.vsu.calculators.NonlinearSystemCalculatorImpl;
import org.junit.Test;

import java.util.Arrays;

public class NonlinearSystemCalculatorTest {

    final private NonlinearSystemCalculator calculator = new NonlinearSystemCalculatorImpl();

    private String functions = "cos(x+0.5)-2-y;sin(y)-2*x-1";
    private String interval = "-10;-5";
    private String x = "x=0.1";
    private String y = "y=1";

    @Test
    public void newton() {
        System.out.println(Arrays.toString(calculator.newton(functions, interval, x, y, 0.001)));
    }

    @Test
    public void simpleIteration() {
        System.out.println(Arrays.toString(calculator.simpleIteration(functions, interval, x, y, 0.001)));
    }

}
