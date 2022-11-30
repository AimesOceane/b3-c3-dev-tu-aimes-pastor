package fr.aimespastor.calculator.resolvable;

import fr.aimespastor.calculator.operator.IOperator;

public class OperatorOperation implements IResolvable{

	private IOperator operator;
	private IResolvable a;
	private IResolvable b;
	
	public OperatorOperation(IOperator operator, IResolvable a, IResolvable b) {
		this.operator = operator;
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double resolve() throws IllegalArgumentException {
		return this.operator.operate(a.resolve(), b.resolve());
	}
	
	
}
