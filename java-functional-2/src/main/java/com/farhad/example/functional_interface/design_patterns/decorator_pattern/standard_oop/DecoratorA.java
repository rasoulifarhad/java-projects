package com.farhad.example.functional_interface.design_patterns.decorator_pattern.standard_oop;

public class DecoratorA extends Decorator {

	protected DecoratorA(Component component) {
		super(component);
	}

	public void operation() {
		super.operation();
		this.addedBehavior();
	}

	private void addedBehavior() {
		System.out.println("Added Behavior A");
	}
}
