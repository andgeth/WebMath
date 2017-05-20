import by.vsu.calculators.BoundaryTaskCalculator;
import by.vsu.calculators.BoundaryTaskCalculatorImpl;
import org.junit.Test;

import java.util.Arrays;

public class BoundaryTaskCalculatorTest {

    private BoundaryTaskCalculator calculator = new BoundaryTaskCalculatorImpl();

    @Test
    public void nets() {
       System.out.println(Arrays.toString(this.calculator.nets(
               "-1;-2;-3*exp^(-x)", "0;1;0", "1;2;0", "0;1", 0.1)));
    }

    @Test
    public void reduction() {
        System.out.println(Arrays.toString(this.calculator.reduction(
                "2*x;-1;2*(x^2+1)*cos(x)", "1;0;0", "1;0;0.2397128", "0;0.5", 0.1)));
    }

    @Test
    public void shoot() {
        System.out.println(Arrays.toString(this.calculator.shoot(
                "-1;-2;-3*exp^(-x)", "0;1;0", "1;2;1", "0;1",
                1, "0;1", 0.1, 0.01)));
    }

}
