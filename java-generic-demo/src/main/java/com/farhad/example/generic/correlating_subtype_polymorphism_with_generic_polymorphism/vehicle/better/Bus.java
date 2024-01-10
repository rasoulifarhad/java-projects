package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.vehicle.better;

public class Bus extends Vehicle<Bus>{

	@Override
	public int compareTo(Bus o) {
		return 0;
	}
	
}
