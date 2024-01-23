package com.farhad.example.functional_interface.design_patterns.decorator_pattern.standard_oop;

public class App {

	public static void main(String[] args) {
		
		Component component = new DecoratorB(
			new DecoratorB(
				new DecoratorA(
								new ComponentA())));
		component.operation();
	}
}
