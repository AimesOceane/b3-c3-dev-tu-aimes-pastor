package fr.aimespastor.calculator.operator;

import java.util.ArrayList;

import fr.aimespastor.calculator.function.IFunction;
import fr.aimespastor.calculator.function.SquareRoot;
import fr.aimespastor.calculator.resolvable.FunctionOperation;
import fr.aimespastor.calculator.resolvable.IResolvable;
import fr.aimespastor.calculator.resolvable.OperatorOperation;
import fr.aimespastor.calculator.resolvable.Value;

public class IResolvableParser {

	private static final ArrayList<IOperator> KNOWN_OPERATORS = new ArrayList<>();
	private static final ArrayList<IFunction> KNOWN_FUNCTIONS = new ArrayList<>();

	static {
		KNOWN_OPERATORS.add(new Plus());
		KNOWN_OPERATORS.add(new Minus());
		KNOWN_OPERATORS.add(new Divide());
		KNOWN_OPERATORS.add(new Multiply());
		
		KNOWN_FUNCTIONS.add(new SquareRoot());
	}

	public static IResolvable parse(String equation) {
		if(equation.startsWith("(") && equation.endsWith(")")) {
			int parenthesisCount = 0;
			boolean shouldRemoveParenthesis = true;
			for(char c : equation.substring(0, equation.length() - 1).toCharArray()) {
//				System.out.println(parenthesisCount + " : " + c);
				if(c == '(') parenthesisCount ++;
				if(c == ')') {
					parenthesisCount --;
					if(parenthesisCount == 0) {
						shouldRemoveParenthesis = false;
						break;
					}
					continue;
				}
			}
			if(shouldRemoveParenthesis) {
//				System.out.println("stripping prenthesis");
				StringBuilder builder = new StringBuilder(equation);
				builder.deleteCharAt(builder.length() - 1);
				builder.deleteCharAt(0);
				equation = builder.toString();
			}
//			System.out.println("new equation : ");
//			System.out.println(equation);
		}

		for(IOperator operator : KNOWN_OPERATORS) {
			OperatorOperation operation = operator.parse(equation);
			if(operation != null) return operation;
		}
		for(IFunction function : KNOWN_FUNCTIONS) {
			FunctionOperation operation = function.parse(equation);
			if(operation != null) return operation;
		}
		try {
			double value = Double.parseDouble(equation);
			return new Value(value);
		}catch (Exception e) {
			try {
				double value = Double.parseDouble("0" + equation);
				return new Value(value);
			}catch (Exception e1) {
				throw new IllegalArgumentException("Was unable to identify part of the equation : " + equation);
			}
		}

	}

}
