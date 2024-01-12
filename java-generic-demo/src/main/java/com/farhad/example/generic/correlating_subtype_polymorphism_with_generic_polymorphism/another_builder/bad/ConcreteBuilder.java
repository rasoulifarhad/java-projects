package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.another_builder.bad;

public class ConcreteBuilder extends ConstraintBuilder {

	@Override
	public Object build() {
		return new Object();
	}

}
