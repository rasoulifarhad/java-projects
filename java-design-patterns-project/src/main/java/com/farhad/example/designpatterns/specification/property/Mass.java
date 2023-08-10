package com.farhad.example.designpatterns.specification.property;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class Mass {
	
	private final double value;

	public boolean greaterThan(Mass other) {
		
		return this.value > other.value;
	}

	public boolean smallerThan(Mass other) {
		return this.value < other.value;
	}

	public boolean smallerThanOrEq(Mass other) {
		return this.value <= other.value;
	}

	public String toString() {
		return value + "kg";
	}
}
