package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.another_builder.recursive_generics;

public class ConcreteBuilder extends ConstraintBuilder<ConcreteBuilder> {

	@Override
	public Object build() {
		return new Object();
	}

}
