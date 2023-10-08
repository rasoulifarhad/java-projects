package com.farhad.example.design_principles02.srp.basic_oop.abstratc_interfaces;

public class App {
	public static void main(String[] args) {
		
		CanadAir myPlane = new CanadAir(0.2, 200, 250, Cargo.WATER);

		System.out.println("myPlane is-a AeroPlane " + (myPlane instanceof AeroPlane));
		System.out.println("myPlane is-a FireFighterPlane " + (myPlane instanceof FireFighterPlane));
		System.out.println("myPlane is-a CanadAir " + (myPlane instanceof CanadAir));

		myPlane.goTo(100, 150);
		myPlane.comeBack();
		myPlane.dropWater();
		myPlane.stopFire();


	}
}
