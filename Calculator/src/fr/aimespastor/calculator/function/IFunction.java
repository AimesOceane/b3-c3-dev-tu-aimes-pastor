package fr.aimespastor.calculator.function;

import fr.aimespastor.calculator.operation.FunctionOperation;

public interface IFunction {

	public double operate(double resolve);
	public FunctionOperation parse(String equation);
	
}
