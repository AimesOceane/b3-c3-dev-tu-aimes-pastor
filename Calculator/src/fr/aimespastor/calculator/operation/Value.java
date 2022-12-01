package fr.aimespastor.calculator.operation;

public class Value implements IOperation{

	private double value;
	
	public Value(double value) {
		this.value = value;
	}

	@Override
	public double resolve() throws IllegalArgumentException {
		return value;
	}
	
	@Override
	public String toString() {
		return value + "";
	}

	@Override
	public String getOperationName() {
		return "VALUE";
	}
}
