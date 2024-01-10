package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.fluent_api.better;

public class Person<T extends Person<T>> {
	private String name;
	private Integer age;

	public T withName(String name) {
		this.name = name;
		return (T) this;
	}
	
	public T withAge(Integer age) {
		this.age = age;
		return (T) this;
	}
}
