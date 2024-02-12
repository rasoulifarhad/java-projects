package com.farhad.example.design_principles02.DOUG_DOG_D00R.first;

public class DogDoorSimulator {

	public static void main(String[] args) {
		DogDoor dogDoor = new DogDoor();
		Remote remote = new Remote(dogDoor);

		System.out.println("Dog barks to go outside...");
		remote.pressButton();
		System.out.println("\nDog has gone outside...");
		remote.pressButton();
		System.out.println("\nDog's all done...");
		remote.pressButton();
		System.out.println("\ndog's back inside...");
		remote.pressButton();
	}
}
