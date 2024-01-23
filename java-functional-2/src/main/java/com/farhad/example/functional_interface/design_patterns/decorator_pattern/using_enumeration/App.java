package com.farhad.example.functional_interface.design_patterns.decorator_pattern.using_enumeration;

public class App {

	public static void main(String[] args) {
		
		Component component = new Decorator(Decoration.DECORATIONB, 
				new Decorator(Decoration.DECORATIONB, 
					new Decorator(Decoration.DECORATIONA,
									new ComponentA())));
		component.operation();
	}
}
