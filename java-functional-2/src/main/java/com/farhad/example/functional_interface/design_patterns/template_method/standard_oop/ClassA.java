package com.farhad.example.functional_interface.design_patterns.template_method.standard_oop;

public class ClassA extends AbstractClass {

	@Override
	protected void primitiveOperation1() {
		System.out.println("primitiveOperation1 called! (" + getClass() + ")");
	}

	@Override
	protected void primitiveOperation2() {
		System.out.println("primitiveOperation2 called! (" + getClass() + ")");
	}

}
