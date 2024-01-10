package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.vehicle.better;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle<E extends Vehicle<E>> implements Comparable<E>{

	private String name;
	private double length;

	@Override
	public int compareTo(E o) {
		double thisLength = this.getLength();

		// Now the following line is an error.
		double thatLength = o.getLength();

		if (thisLength > thatLength)
			return 1;
		else if (thisLength < thatLength)
			return -1;

		return 0;
	}

}
