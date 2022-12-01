package fr.aimespastor.calculator.operator;

import fr.aimespastor.calculator.operation.OperatorOperation;

public interface IOperator {

	public double operate(double a, double b);
	public OperatorOperation parse(String equation);
	
}
