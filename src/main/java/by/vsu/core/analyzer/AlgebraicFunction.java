/*
 * type		function	arguments
 * 0		number		value
 * 1		x			xindex
 * 2		+			func1, func2
 * 3		-			func1, func2
 * 4		*			func1, func2
 * 5		/			func1, func2
 * 6		pow			func1, func2
 * 7		root		func1, func2
 * 8		log			func1, func2
 * 9		lg			func1
 * 10		lb			func1
 * 11		ln			func1
 * 12		exp			func1
 * 13		sin			func1
 * 14		cos			func1
 * 15		tg			func1
 * 16		ctg			func1
 * 17		sec			func1
 * 18		csc			func1
 * 19		asin		func1
 * 20		acos		func1
 * 21		atg			func1
 * 22		actg		func1
 * 23		asec		func1
 * 24		acsc		func1
 * 25		sinh		func1
 * 26		cosh		func1
 * 27		tgh			func1
 * 28		ctgh		func1
 * 29		sech		func1
 * 30		csch		func1
 */

package by.vsu.core.analyzer;

import by.vsu.core.analyzer.algebra.Changeable;
import by.vsu.core.analyzer.algebra.MathExpression;
import by.vsu.core.analyzer.algebra.Number;
import by.vsu.core.analyzer.algebra.VariableValuePair;

public class AlgebraicFunction {

    private MathExpression mathExpression;
    private String strView;

    public AlgebraicFunction(String str) {
        this.mathExpression = Analyzer.disassemble(str);
        this.strView = str;
    }

    public String getDependencies() {
        return mathExpression.getDependencies();
    }

    public String getStrView() {
        return strView;
    }

    public double getDerivativeValue(String nameVariable) {
        return this.mathExpression.calculateDerivative(nameVariable);
    }

    public double getValue() {
        return this.mathExpression.calculate();
    }

    public void insertValue(double val) {
        if (this.mathExpression.getClass() != Number.class) {
            ((Changeable) this.mathExpression).insertValue(val);
        }
    }

    public void insertValues(VariableValuePair[] vvp) {
        if (this.mathExpression.getClass() != Number.class) {
            ((Changeable) this.mathExpression).insertValues(vvp);
        }
    }

    public String toString() {
        return mathExpression.toString();
    }

}
