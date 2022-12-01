package fr.aimespastor.calculator.operator;

public class Power extends AbstractSimpleOperator{

	public Power() {
		super('^');
	}

	@Override
	public double operate(double a, double b) {
		return Math.pow(a, b);
	}
	
}
