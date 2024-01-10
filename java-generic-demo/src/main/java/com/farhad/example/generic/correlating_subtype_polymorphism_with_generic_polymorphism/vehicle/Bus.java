package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.vehicle;

public class Bus extends Vehicle implements Comparable<Bus>{

	@Override
	public int compareTo(Bus o) {
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
