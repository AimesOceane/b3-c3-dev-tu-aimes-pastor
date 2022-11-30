package fr.aimespastor.calculator.resolvable;

public class Value implements IResolvable{

	private double value;
	
	public Value(double value) {
		this.value = value;
	}

	@Override
	public double resolve() throws IllegalArgumentException {
		return value;
	}
}
