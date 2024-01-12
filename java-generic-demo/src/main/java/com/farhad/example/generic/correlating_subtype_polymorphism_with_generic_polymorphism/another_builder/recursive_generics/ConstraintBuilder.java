package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.another_builder.recursive_generics;

@SuppressWarnings("unchecked")

public abstract class ConstraintBuilder<E extends ConstraintBuilder<E>> extends BaseBuilder<E> {

	public E equalTo(Number value) {
		return (E) this;
	}

	public E greaterThan(Number value) {
		return (E) this;
	}

	public E lessThan(Number value) {
		return (E) this;
	}

	public E greaterOrEqualTo(Number value) {
		return (E) this;
	}

	public E lessOrEqualTo(Number value) {
		return (E) this;
	}
}
