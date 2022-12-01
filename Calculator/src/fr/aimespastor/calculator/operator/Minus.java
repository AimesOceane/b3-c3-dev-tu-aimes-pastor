package fr.aimespastor.calculator.operator;

public class Minus extends AbstractSimpleOperator{

	public Minus() {
		super(getCharacter());
	}
	
	@Override
	public double operate(double a, double b) {
		return a - b;
	}

	public static char getCharacter() {
		return '-';
	}

}
