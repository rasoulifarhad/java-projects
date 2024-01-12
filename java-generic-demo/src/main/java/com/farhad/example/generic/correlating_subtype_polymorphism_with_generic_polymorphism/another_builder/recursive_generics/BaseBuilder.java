package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.another_builder.recursive_generics;

@SuppressWarnings("unchecked")
public abstract class BaseBuilder<E extends BaseBuilder<E>> {

	private void addField(Class<?> clazz, String name) {
	}

	public E addIntField(String name) {
		addField(Integer.class, name);
		return (E) this;
	}
	
	public E addLongField(String name) {
		addField(Long.class, name);
		return (E) this;
	}

	public E addDoubleField(String name) {
		addField(Double.class, name);
		return (E) this;
	}

	public abstract Object build();
}
