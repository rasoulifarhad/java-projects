package com.farhad.example.functional_interface.design_patterns.decorator_pattern.using_enumeration_02;

public class App {

	public static void main(String[] args) {
		
		Component component = new Decorator(
				new ComponentA(), 
				Decoration.DECORATIONB,
				Decoration.DECORATIONB,
				Decoration.DECORATIONA);
		component.operation();
				
	}
}
