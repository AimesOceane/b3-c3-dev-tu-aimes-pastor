package fr.aimespastor.calculator.operator;

import fr.aimespastor.calculator.operation.OperatorOperation;
import fr.aimespastor.calculator.resolvable.IResolvableParser;

public abstract class AbstractSimpleOperator implements IOperator {

	private char character; 
	
	public AbstractSimpleOperator(char character) {
		this.character = character;
	}

	@Override
	public OperatorOperation parse(String equation) {
		String a = "";
		String b = "";
		StringBuilder buffer = new StringBuilder(equation.length());
		int parenthesisCount = 0;
		int index = -1;
		boolean matches = false;
		
		for(char c : new StringBuilder(equation).reverse().toString().toCharArray()) {
			if(matches) {
				buffer.insert(0, c);
				continue;
			}
			index ++;
			if(c == '(') parenthesisCount --;
			else if(c == ')') parenthesisCount ++;
			if(parenthesisCount > 0 || c != character) {
				buffer.insert(0, c);
				continue;
			}
			matches = true;
			a = buffer.toString();
			buffer = new StringBuilder(equation.length());
		}
		b = buffer.toString();
		if(!matches) return null;
//		System.out.println(b + " <" + this.character + "> " + a);
		return new OperatorOperation(this, IResolvableParser.parse(b), IResolvableParser.parse(a), index);
	}

	@Override
	public String toString() {
		return this.character + "";
	}
	
}
