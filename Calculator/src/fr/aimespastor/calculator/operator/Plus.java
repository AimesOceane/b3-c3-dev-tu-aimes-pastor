package fr.aimespastor.calculator.operator;

public class Plus extends SimpleOperator{
	
	public Plus() {
		super('+');
	}
	
	@Override
	public double operate(double a, double b) {
		return a + b;
	}
}

