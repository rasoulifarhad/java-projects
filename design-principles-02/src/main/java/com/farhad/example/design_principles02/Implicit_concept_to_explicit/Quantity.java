package com.farhad.example.design_principles02.Implicit_concept_to_explicit;

import com.farhad.example.design_principles02.good_code.ocp.Util;

// Quantity is implicit concept. 
public final class Quantity {
	
	private final int value;

	public Quantity(int value) {
		Util.isTrue(value > 0 , "Quantity must be greater than zero. Got: %s",value);
		this.value = value;
	}

	public int value() {
		return value;
	}
}
