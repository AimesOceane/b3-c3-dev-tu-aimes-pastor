package fr.aimespastor.calculator.resolvable;

import fr.aimespastor.calculator.function.IFunction;

public class FunctionOperation implements IResolvable{

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
	
}
