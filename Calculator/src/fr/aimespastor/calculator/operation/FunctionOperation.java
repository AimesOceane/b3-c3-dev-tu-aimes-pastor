package fr.aimespastor.calculator.operation;

import fr.aimespastor.calculator.function.IFunction;
import fr.aimespastor.calculator.resolvable.IResolvable;

public class FunctionOperation implements IOperation{

	private IFunction function;
	private IResolvable a;
	
	public FunctionOperation(IFunction function, IResolvable a) {
		this.function = function;
		this.a = a;
	}
	
	@Override
	public double resolve() {
		return this.function.operate(a.resolve());
	}
	
	@Override
	public String toString() {
		return function + "( " + a + " )";
	}

	@Override
	public String getOperationName() {
		return getClass().getSimpleName().toUpperCase();
	}
	
}
