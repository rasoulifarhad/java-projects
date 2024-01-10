package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.vehicle.bad2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle implements Comparable<Vehicle>{

	private String name;
	private double length;
	
	@Override
	public int compareTo(Vehicle o) {
		double thisLength = this.getLength();
		double thatLength = o.getLength();

		if (thisLength > thatLength) {
			return 1;
		} else if (thisLength < thatLength) {
			return -1;
		}

		return 0;
	}

	
}
