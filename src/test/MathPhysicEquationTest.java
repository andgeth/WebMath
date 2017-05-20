import by.vsu.core.mathphysiceq.HyperbolicEquation;
import by.vsu.core.mathphysiceq.ParabolicEquation;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathPhysicEquationTest {

    private String initialConditions = "2*x*(x+1)+0.3;2*sin(x)";
    private String boundaryConditions = "0.3;4.3+t";
    private double[] x = new double[] { 0, 1 };
    private double[] t = new double[] { 0, 0.5 };
    private double hx = 0.1;
    private double ht = 0.1;

    @Test
    public void hyperbolic() {
        HyperbolicEquation hyperbolicEquation = new HyperbolicEquation(
                initialConditions.split(";"),
                boundaryConditions.split(";"),
                x[0], x[1],
                t[0], t[1],
                hx, ht);
        System.out.println(hyperbolicEquation.solve());
    }

    @Test
    public void parabolic() {
        ParabolicEquation parabolicEquation = new ParabolicEquation(
            "0.5*sin(PI/2)*x+1.6-cos(PI/2)*x",
                "1.6*(t+1);0.5*(t^2+1)".split(";"),
                "2.41*(x^2-t^2)+0.48*t*x-0.378*(0.48-1.9)",
                0, 1, 0, 0.001, 0.1, 0.0005);
        double[][] res = parabolicEquation.solve(1);
        for (double[] arr : res) {
            for (double el : arr) {
                System.out.print(new BigDecimal(el).setScale(5, RoundingMode.FLOOR).doubleValue() + " ");
            }
            System.out.println();
        }
    }

}
