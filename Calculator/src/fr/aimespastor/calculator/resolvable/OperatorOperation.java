package fr.aimespastor.calculator.resolvable;

import fr.aimespastor.calculator.operator.IOperator;

public class OperatorOperation implements IResolvable{

	private IOperator operator;
	private IResolvable a;
	private IResolvable b;
	public final int index; //Used to know the leftmost operation
	
	public OperatorOperation(IOperator operator, IResolvable a, IResolvable b, int index) {
		this.operator = operator;
		this.a = a;
		this.b = b;
		this.index = index;
	}
	
	@Override
	public double resolve() throws IllegalArgumentException {
		return this.operator.operate(a.resolve(), b.resolve());
	}
	
	@Override
	public String toString() {
		return "(" + a + " " + operator + " " + b + ")";
	}
	
	
}
