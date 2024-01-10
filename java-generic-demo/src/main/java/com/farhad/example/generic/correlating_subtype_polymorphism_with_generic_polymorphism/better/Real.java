package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.better;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Real extends Number<Real> {

	@Getter
	private final double value;

	@Override
	public int compareTo(Real o) {
		return Double.compare(value, o.getValue());
	}

}
