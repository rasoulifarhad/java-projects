package com.farhad.example.design_principles02.srp.basic_oop.inheritance_polymorphism;

public class FireFighterPlane extends AeroPlane {

	public FireFighterPlane(double consumption, double autonomy, int capacity) {
		super(consumption, autonomy, capacity, Cargo.WATER);
	}

	public void dropWater() {
		System.out.println("water droped");
	}
	
}
