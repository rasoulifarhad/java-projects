package com.farhad.example.design_principles02.srp.basic_oop.inheritance_polymorphism;

public class App {
	
	public static void main(String[] args) {
		AeroPlane myPlane = new AeroPlane(0.2, 200, 2, Cargo.CARGO.PASSENGER);

		System.out.println("myPlane is-a Object " + (myPlane instanceof Object));
		System.out.println("myPlane is-a AeroPlane " + (myPlane instanceof AeroPlane));
		System.out.println("myPlane is-a FireFighterPlane " + (myPlane instanceof FireFighterPlane));

		myPlane.goTo(50, 2);

		AeroPlane fireFighterPlane = new FireFighterPlane(0.2, 200, 250);

		System.out.println();
		System.out.println("fireFighterPlane is-a AeroPlane " + (fireFighterPlane instanceof AeroPlane));
		System.out.println("fireFighterPlane is-a FireFighterPlane " + (fireFighterPlane instanceof FireFighterPlane));

		fireFighterPlane.goTo(200, 100);

		((FireFighterPlane)fireFighterPlane).dropWater();

		FireFighterPlane fireFighterPlane2 = (FireFighterPlane)fireFighterPlane;
		fireFighterPlane2.dropWater();
	}
}
