package fr.aimespastor.calculator;

import java.util.Scanner;

import fr.aimespastor.calculator.resolvable.Equation;

public class Calculator {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			String input = sc.nextLine();
			if(input.equalsIgnoreCase("exit")) return;
			Equation equation = new Equation(input);
			System.out.println(equation);
			System.out.println(equation.resolve());
		}
	}
	
}
