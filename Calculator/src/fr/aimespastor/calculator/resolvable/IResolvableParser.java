package fr.aimespastor.calculator.resolvable;

import java.util.ArrayList;

import fr.aimespastor.calculator.function.IFunction;
import fr.aimespastor.calculator.function.SquareRoot;
import fr.aimespastor.calculator.operation.FunctionOperation;
import fr.aimespastor.calculator.operation.IOperation;
import fr.aimespastor.calculator.operation.OperatorOperation;
import fr.aimespastor.calculator.operation.Value;
import fr.aimespastor.calculator.operator.Divide;
import fr.aimespastor.calculator.operator.IOperator;
import fr.aimespastor.calculator.operator.Minus;
import fr.aimespastor.calculator.operator.Multiply;
import fr.aimespastor.calculator.operator.Plus;
import fr.aimespastor.calculator.operator.Power;

public class IResolvableParser {

	private static final ArrayList<ArrayList<IOperator>> KNOWN_OPERATORS = new ArrayList<>();
	private static final ArrayList<IFunction> KNOWN_FUNCTIONS = new ArrayList<>();

	static {
		ArrayList<IOperator> Stage1 = new ArrayList<>();
		Stage1.add(new Plus());
		Stage1.add(new Minus());
//		Stage1.add(new MultiplicativePercentile());

		ArrayList<IOperator> Stage2 = new ArrayList<>();
		Stage2.add(new Divide());
		Stage2.add(new Multiply());

		ArrayList<IOperator> Stage3 = new ArrayList<>();
		Stage3.add(new Power());

		KNOWN_OPERATORS.add(Stage1);
		KNOWN_OPERATORS.add(Stage2);
		KNOWN_OPERATORS.add(Stage3);
		KNOWN_FUNCTIONS.add(new SquareRoot());
	}

	public static IOperation parse(String equation) {
		final IOperation operation = _parse(equation);
		System.out.println(operation.getOperationName() + " \t\t => " + equation + "\n\t\t => " + operation + " \n========================> ");
		return operation;
	}
	
	public static IOperation _parse(String equation) {
		equation = removeParenthesis(equation);
//		System.out.println(equation);

		for(ArrayList<IOperator> OPERATOR_STAGE : KNOWN_OPERATORS) {
			OperatorOperation resolvable = null;
			for(IOperator operator : OPERATOR_STAGE) {
				OperatorOperation operation = operator.parse(equation);
				if(operation != null && (resolvable == null || operation.index < resolvable.index)) resolvable = operation;
			}
			if(resolvable != null) return resolvable;
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
				throw new IllegalArgumentException("Was unable to identify part of the equation : \"" + equation + "\"");
			}
		}

	}

	private static String removeParenthesis(String equation) {
		equation = equation.trim();
		while(equation.startsWith("(") && equation.endsWith(")")) {
			int parenthesisCount = 0;
			boolean shouldRemoveParenthesis = true;
			for(char c : equation.substring(0, equation.length() - 1).toCharArray()) {
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
				StringBuilder builder = new StringBuilder(equation);
				builder.deleteCharAt(builder.length() - 1);
				builder.deleteCharAt(0);
				equation = builder.toString().trim();
			}else break;
		}
		return equation;
	}

}
