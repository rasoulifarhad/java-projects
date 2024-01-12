package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.another_builder.covariant_return_types;

public class ConcreteBuilder extends ConstraintBuilder {

	@Override
	public Object build() {
		return new Object();
	}

}
