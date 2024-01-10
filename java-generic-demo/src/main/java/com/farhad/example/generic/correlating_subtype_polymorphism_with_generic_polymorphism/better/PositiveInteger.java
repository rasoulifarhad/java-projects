package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.better;

import lombok.Getter;

public class PositiveInteger extends Number<PositiveInteger> {

	@Getter
	private final int value;

	public PositiveInteger(int value) {
		if (value < 0) {
			throw new IllegalArgumentException();
		}
		this.value = value;
	}

	@Override
	public int compareTo(PositiveInteger o) {
		return Integer.compare(value, o.getValue());
	}

	
}
