package fr.aimespastor.calculator.operator;

public class Minus extends SimpleOperator{

	public Minus() {
		super('-');
	}
	
	@Override
	public double operate(double a, double b) {
		return a - b;
	}

	@Override
	public String toString() {
		return "-";
	}

}
