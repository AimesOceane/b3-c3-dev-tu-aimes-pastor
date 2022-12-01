package fr.aimespastor.calculator.resolvable;

import java.util.ArrayList;

public class Equation implements IResolvable{

	private IResolvable equation;
	
	public Equation(String equation) {
		ArrayList<String> parts = new ArrayList<>();
		StringBuilder buffer = new StringBuilder(equation.length());
		int parenthesisCount = 0;
		int charId = 0;
		
		for(char c : equation.toCharArray()) {
			charId++;
			if(c == '(') {
				if(parenthesisCount == 0) {
					if(buffer.length() != 0) parts.add(buffer.toString().trim());
					buffer = new StringBuilder(equation.length() - charId);
				}
				buffer.append(c);
				parenthesisCount ++;
				continue;
			}
			if(c == ')') {
				buffer.append(c);
				if(parenthesisCount == 1) {
					if(buffer.length() != 0) parts.add(buffer.toString().trim());
					buffer = new StringBuilder(equation.length() - charId);
				}
				parenthesisCount --;
				if(parenthesisCount < 0) throw new IllegalArgumentException("Encountered an unexpected closing parenthesis at character " + charId);
				continue;
			}
			buffer.append(c);
		}
		if(buffer.length() != 0) parts.add(buffer.toString().trim());
		if(parenthesisCount != 0) throw new IllegalArgumentException("Expected " + parenthesisCount +" closing parenthesis but never found any");
		
//		StringBuilder builder = new StringBuilder();
//		for(String part : parts) {
//			builder.append(" | " + part);
//		}
		
		this.equation = IResolvableParser.parse(equation);
		
	}

	@Override
	public double resolve() {
		return equation.resolve();
	}

	@Override
	public String toString() {
		return equation.toString();
	}
}
