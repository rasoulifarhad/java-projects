package com.farhad.example.functional_interface.design_patterns.decorator_pattern.standard_oop;

public class DecoratorB extends Decorator {

	protected DecoratorB(Component component) {
		super(component);
	}

	@Override
	public void operation() {
		super.operation();
		this.addedBehavior();
	}

	private void addedBehavior() {
		System.out.println("Added Behavior B");

	}

}
