package fr.aimespastor.calculator.operator;

public class Plus extends AbstractSimpleOperator{
	
	public Plus() {
		super(getCharacter());
	}
	
	@Override
	public double operate(double a, double b) {
		return a + b;
	}

	public static char getCharacter() {
		return '+';
	}
}

