package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.another_builder.covariant_return_types;

public class ConcreteBuilder extends ConstraintBuilder {

	@Override
	public Object build() {
		return new Object();
	}

	@Override
	public ConcreteBuilder equalTo(Number value) {
		return (ConcreteBuilder) super.equalTo(value);
	}

	@Override
	public ConcreteBuilder greaterOrEqualTo(Number value) {
		return (ConcreteBuilder) super.greaterOrEqualTo(value);
	}

	@Override
	public ConcreteBuilder greaterThan(Number value) {
		return (ConcreteBuilder) super.greaterThan(value);
	}

	@Override
	public ConcreteBuilder lessOrEqualTo(Number value) {
		return (ConcreteBuilder) super.lessOrEqualTo(value);
	}

	@Override
	public ConcreteBuilder lessThan(Number value) {
		return (ConcreteBuilder) super.lessThan(value);
	}

	@Override
	public ConcreteBuilder addDoubleField(String name) {
		return (ConcreteBuilder) super.addDoubleField(name);
	}

	@Override
	public ConcreteBuilder addIntField(String name) {
		return (ConcreteBuilder) super.addIntField(name);
	}

	@Override
	public ConcreteBuilder addLongField(String name) {
		return (ConcreteBuilder) super.addLongField(name);
	}

	
}
