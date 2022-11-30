package fr.aimespastor.calculator.operator;

public class Multiply extends SimpleOperator{

	public Multiply() {
		super('*');
	}

	@Override
	public double operate(double a, double b) {
		return a*b;
	}

	@Override
	public String toString() {
		return "*";
	}
}
