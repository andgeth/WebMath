import by.vsu.core.mathphysiceq.ParabolicEquation;
import org.junit.Test;

public class ParabolicEquationTest {

    private String initialCondition = "0.4*sin(PI/2*x)+1.7*cos(PI/2*x)";
    private String boundConditions = "1.7*(t+1);0.4*(t^2+1)";
    private String function = "-1.85*(x^2-t^2)+2.31*t*x-0.378*(0.36-1.9)";
    private double a = 0, b = 1;
    private double a1= 0, b1 = 0.01;
    private double hx = 0.1, ht = 0.005;

    @Test
    public void solve() {
        ParabolicEquation parabolicEquation = new ParabolicEquation(
                initialCondition,
                boundConditions.split(";"),
                function,
                a, b, a1, b1, hx, ht);
        double[][] solve = parabolicEquation.solve(0);
        for (double[] d : solve) {
            for (double dd : d) {
                System.out.print(dd + " ");
            }
            System.out.println();
        }
    }

}
