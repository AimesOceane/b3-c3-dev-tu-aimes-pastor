package fr.aimespastor.calculator.operator;

public class Divide extends AbstractSimpleOperator{

	public Divide() {
		super(getCharacter());
	}

	@Override
	public double operate(double a, double b) {
		return a/b;
	}

	public static char getCharacter() {
		return '/';
	}
	
}
