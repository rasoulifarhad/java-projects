package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.bad;

import lombok.Getter;

public class PositiveInteger extends Number {

	@Getter
	private final int value;
	
	
	public PositiveInteger(int value) {
		if (value < 0) {
			throw new IllegalArgumentException();
		}
		this.value = value;
	}


	@Override
	public int compareTo(Number o) {
		if (o instanceof PositiveInteger ) {
			return Integer.compare(value, ((PositiveInteger) o).value);
		}
		throw new IllegalArgumentException();
	}

}
