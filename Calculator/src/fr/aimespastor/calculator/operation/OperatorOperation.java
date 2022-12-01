package fr.aimespastor.calculator.operation;

import fr.aimespastor.calculator.operator.IOperator;
import fr.aimespastor.calculator.resolvable.IResolvable;

public class OperatorOperation implements IOperation{

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
	
	@Override
	public String getOperationName() {
		return this.operator.getClass().getSimpleName().toUpperCase();
	}
}
