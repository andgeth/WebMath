import by.vsu.calculators.InterpolationCalculator;
import by.vsu.calculators.InterpolationCalculatorImpl;
import org.junit.Test;

public class InterpolationCalculatorTest {

    private InterpolationCalculator calculator = new InterpolationCalculatorImpl();
    private String xValues = "1,3,5,7,9,10";
    private String yValues = "0.5,3.598,6.109,8.445,10.697,11.803";
    private String points = "1;2;3";

    @Test
    public void newton() {
        System.out.println(calculator.newton(xValues, yValues, points,  4.63));
    }

    @Test
    public void lagrange() {
        System.out.println(calculator.lagrange(xValues, yValues, points, 4.63));
    }

    @Test
    public void spline() {
        System.out.println(calculator.spline(xValues, yValues, 1.1));
    }

}
