package by.vsu.core.analyzer.algebra;

public class VariableValuePair implements Comparable<VariableValuePair> {

    private String nameVariable;
    private double value;

    public VariableValuePair(String pair) {
        String[] tmp = pair.split("=");
        nameVariable = tmp[0];
        value = Double.parseDouble(tmp[1]);

    }

    public VariableValuePair(String name, double value) {
        this.nameVariable = name;
        this.value = value;
    }

    public VariableValuePair(VariableValuePair vvPair) {
        this.nameVariable = vvPair.nameVariable;
        this.value = vvPair.value;
    }

    public void assign(double val) {
        this.value = val;
    }

    public void assign(VariableValuePair otherPair) {
        if (nameVariable.equals(otherPair.nameVariable)) {
            value = otherPair.value;
        }
    }

    public String getNameVariable() {
        return this.nameVariable;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public int compareTo(VariableValuePair o) {
        return Double.compare(this.value, o.value);
    }

    @Override
    public String toString() {
        return "nameVariable='" + nameVariable + '\'' + ", value=" + value;
    }

}
