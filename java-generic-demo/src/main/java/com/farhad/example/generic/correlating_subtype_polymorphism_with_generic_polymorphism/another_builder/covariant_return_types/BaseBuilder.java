package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.another_builder.covariant_return_types;

public abstract class BaseBuilder {

	private void addField(Class<?> clazz, String name) {
	}

	public BaseBuilder addIntField(String name) {
		addField(Integer.class, name);
		return this;
	}
	
	public BaseBuilder addLongField(String name) {
		addField(Long.class, name);
		return this;
	}

	public BaseBuilder addDoubleField(String name) {
		addField(Double.class, name);
		return this;
	}

	public abstract Object build();
}
