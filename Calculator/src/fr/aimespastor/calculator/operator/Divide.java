package fr.aimespastor.calculator.operator;

public class Divide extends SimpleOperator{

	public Divide() {
		super('/');
	}

	@Override
	public double operate(double a, double b) {
		return a/b;
	}

}
