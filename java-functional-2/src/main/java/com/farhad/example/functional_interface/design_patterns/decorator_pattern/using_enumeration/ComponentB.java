package com.farhad.example.functional_interface.design_patterns.decorator_pattern.using_enumeration;

public class ComponentB implements Component{
	@Override
	public void operation() {
		System.out.println("operation: " + getClass());
	}
}
