package fr.aimespastor.calculator.function;

import fr.aimespastor.calculator.operator.IResolvableParser;
import fr.aimespastor.calculator.resolvable.FunctionOperation;

public class SquareRoot implements IFunction{

	@Override
	public double operate(double resolve) {
		return Math.sqrt(resolve);
	}

	@Override
	public FunctionOperation parse(String equation) {
		if(!equation.startsWith("sqrt")) return null;
		return new FunctionOperation(this, IResolvableParser.parse(equation.replaceFirst("sqrt", "")));
	}

}
