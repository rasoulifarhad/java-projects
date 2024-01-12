package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.another_builder.bad;

public abstract class ConstraintBuilder extends BaseBuilder {

	public ConstraintBuilder equalTo(Number value) {
		return this;
	}

	public ConstraintBuilder greaterThan(Number value) {
		return this;
	}

	public ConstraintBuilder lessThan(Number value) {
		return this;
	}

	public ConstraintBuilder greaterOrEqualTo(Number value) {
		return this;
	}

	public ConstraintBuilder lessOrEqualTo(Number value) {
		return this;
	}
}
