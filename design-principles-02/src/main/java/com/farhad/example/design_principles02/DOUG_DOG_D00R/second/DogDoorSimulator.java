package com.farhad.example.design_principles02.DOUG_DOG_D00R.second;

public class DogDoorSimulator {

	public static void main(String[] args) {
		DogDoor dogDoor = new DogDoor();
		Remote remote = new Remote(dogDoor);

		System.out.println("Dog barks to go outside...");
		remote.pressButton();

		System.out.println("\nDog has gone outside...");

		System.out.println("\nDog's all done...");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println();
		}

		System.out.println("...but he's stuck outside!");

		System.out.println("\ndog starts barking...");
		System.out.println("...so she/he grabs the remote control.");
		remote.pressButton();
		System.out.println("\nDog's back inside...");
	}
}
