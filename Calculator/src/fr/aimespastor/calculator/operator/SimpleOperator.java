package fr.aimespastor.calculator.operator;

import fr.aimespastor.calculator.resolvable.OperatorOperation;

public abstract class SimpleOperator implements IOperator {

	private char character; 
	
	public SimpleOperator(char character) {
		this.character = character;
	}

	@Override
	public OperatorOperation parse(String equation) {
		String a = "";
		String b = "";
		StringBuilder buffer = new StringBuilder(equation.length());
		int parenthesisCount = 0;
		boolean matches = false;
		
		for(char c : equation.toCharArray()) {
			if(matches) {
				buffer.append(c);
				continue;
			}
			if(c == '(') parenthesisCount ++;
			else if(c == ')') parenthesisCount --;
			if(parenthesisCount > 0 || c != character) {
				buffer.append(c);
				continue;
			}
			matches = true;
			a = buffer.toString();
			buffer = new StringBuilder(equation.length());
		}
		b = buffer.toString();
		if(!matches) return null;
		return new OperatorOperation(this, IResolvableParser.parse(a), IResolvableParser.parse(b));
	}

}
