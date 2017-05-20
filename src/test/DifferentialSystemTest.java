import by.vsu.calculators.DifferentialSystemCalculator;
import by.vsu.calculators.DifferentialSystemCalculatorImpl;
import org.junit.Test;

import java.util.Arrays;

public class DifferentialSystemTest {

    private DifferentialSystemCalculator calculator = new DifferentialSystemCalculatorImpl();
    private String functions = "z-cos(x);y+cos(x)";
    private String interval = "0;1";
    private String y0 = "y=0";
    private String z0 = "z=0";
    private double h = 0.1;

    @Test
    public void euler() {
        System.out.println(Arrays.deepToString(calculator.euler(functions, interval, y0, z0, h)));
    }

    @Test
    public void rungeKutta() {
        System.out.println(Arrays.deepToString(calculator.rungeKutta(functions, interval, y0, z0, h)));
    }

}
