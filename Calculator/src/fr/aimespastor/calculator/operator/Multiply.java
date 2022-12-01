package fr.aimespastor.calculator.operator;

public class Multiply extends AbstractSimpleOperator{

	public Multiply() {
		super(getCharacter());
	}

	@Override
	public double operate(double a, double b) {
		return a*b;
	}

	public static char getCharacter() {
		return '*';
	}
}
