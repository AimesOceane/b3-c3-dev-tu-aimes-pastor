package fr.aimespastor.calculator.operator;

import java.util.ArrayList;

import fr.aimespastor.calculator.function.IFunction;
import fr.aimespastor.calculator.function.SquareRoot;
import fr.aimespastor.calculator.resolvable.FunctionOperation;
import fr.aimespastor.calculator.resolvable.IResolvable;
import fr.aimespastor.calculator.resolvable.OperatorOperation;
import fr.aimespastor.calculator.resolvable.Value;

public class IResolvableParser {

	private static final ArrayList<IOperator> KNOWN_STAGEONE_OPERATORS = new ArrayList<>();
	private static final ArrayList<IOperator> KNOWN_STAGETWO_OPERATORS = new ArrayList<>();
	private static final ArrayList<IFunction> KNOWN_FUNCTIONS = new ArrayList<>();

	static {
		KNOWN_STAGEONE_OPERATORS.add(new Plus());
		KNOWN_STAGEONE_OPERATORS.add(new Minus());
		
		KNOWN_STAGETWO_OPERATORS.add(new Divide());
		KNOWN_STAGETWO_OPERATORS.add(new Multiply());
		
		KNOWN_FUNCTIONS.add(new SquareRoot());
	}

	public static IResolvable parse(String equation) {
		equation = equation.trim();
		while(equation.startsWith("(") && equation.endsWith(")")) {
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
				equation = builder.toString().trim();
			}else break;
//			System.out.println("new equation : ");
//			System.out.println(equation);
		}

		
		OperatorOperation resolvable = null;
		for(IOperator operator : KNOWN_STAGEONE_OPERATORS) {
			OperatorOperation operation = operator.parse(equation);
			if(operation != null && (resolvable == null || operation.index > resolvable.index)) resolvable = operation;
		}
		if(resolvable != null) return resolvable;
		
		for(IOperator operator : KNOWN_STAGETWO_OPERATORS) {
			OperatorOperation operation = operator.parse(equation);
			if(operation != null && (resolvable == null || operation.index > resolvable.index)) resolvable = operation;
		}
		if(resolvable != null) return resolvable;
		
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
				throw new IllegalArgumentException("Was unable to identify part of the equation : \"" + equation + "\"");
			}
		}

	}

}
