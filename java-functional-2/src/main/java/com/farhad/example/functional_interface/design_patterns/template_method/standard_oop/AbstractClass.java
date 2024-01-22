package com.farhad.example.functional_interface.design_patterns.template_method.standard_oop;

public abstract class AbstractClass {

	public final void templateMethod() {

		primitiveOperation1();
		primitiveOperation2();
	}

	protected abstract void primitiveOperation1();

	protected abstract void primitiveOperation2();
}
