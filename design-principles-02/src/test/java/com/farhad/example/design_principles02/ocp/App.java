package com.farhad.example.design_principles02.ocp;

public class App {
	
	public static void main(String[] args) {
		
		int number1 = 100;
		int number2 = 200;

		Addition add = new Addition(number1, number2);
		System.out.println(add.result());

		Subtraction sub = new Subtraction(number1, number2);
		System.out.println(sub.result());
	}
}
