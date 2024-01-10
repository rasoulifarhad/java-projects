
package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Real extends Number {

	@Getter
	private final double value;


	@Override
	public int compareTo(Number o) {
		if (o instanceof Real) {
			return Double.compare(value, ((Real) o).getValue());
		}
		throw new IllegalArgumentException();
	}

}
