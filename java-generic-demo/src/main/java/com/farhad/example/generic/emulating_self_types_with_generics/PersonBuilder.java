package com.farhad.example.generic.emulating_self_types_with_generics;

import lombok.Getter;

@Getter
public class PersonBuilder<THIS> {

	private String name;

	public THIS withName(String name) {
		this.name = name;
		return (THIS) this;
	}
}
