package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.vehicle.bad;

public class Car extends Vehicle implements Comparable<Car> {

	@Override
	public int compareTo(Car o) {
		double thisLength = this.getLength();
		double thatLength = o.getLength();

		if(thisLength > thatLength) {
			return 1;
		} else if (thisLength < thatLength) {
			return -1;
		}
		
		return 0;
	}

}
