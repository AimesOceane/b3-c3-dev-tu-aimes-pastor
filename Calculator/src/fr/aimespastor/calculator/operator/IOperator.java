package fr.aimespastor.calculator.operator;

import fr.aimespastor.calculator.resolvable.OperatorOperation;

public interface IOperator {

	public double operate(double a, double b);
	public OperatorOperation parse(String equation);
	
}
