package by.vsu.analyzer.operators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number implements MathExpression {
    private double value = 0;
    private final static Pattern CONSTANT = Pattern.compile("(-?(exp|PI))");

    public Number(String str) {
        Matcher m = this.CONSTANT.matcher(str);
        if (m.matches()) {
            switch (str.substring(m.start(2))) {
                case "exp":
                    this.value = str.charAt(0) == '-' ? -Math.E : Math.E;
                    break;
                case "PI":
                    this.value = str.charAt(0) == '-' ? -Math.PI : Math.PI;
                    break;
            }
        } else {
            this.value = Double.parseDouble(str);
        }
    }

    @Override
    public double calculate() {
        return this.value;
    }

    @Override
    public double calculateDerivative(String nameVariable) {
        return 0;
    }

    @Override
    public String getDependencies() {
        return "";
    }
}
