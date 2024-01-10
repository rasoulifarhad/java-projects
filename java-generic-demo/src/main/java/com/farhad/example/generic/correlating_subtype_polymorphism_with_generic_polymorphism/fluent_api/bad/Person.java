package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.fluent_api.bad;

import lombok.Getter;

@Getter
public class Person {

	private String name;
	private Integer age;

	public Person withName(String name) {
		this.name = name;
		return this;
	}

	public Person withAge(Integer age) {
		this.age = age;
		return this;
	}
}
