package com.farhad.example.design_principles02.DOUG_DOG_D00R.third;

//
// 1. Dog barks to be let out
// 2. She/He hears dog barking.
//
//    2.1 The bark recognizer hears a bark
//
// 3. She/He presses the button on the remote control. 
//
//    3.1 The bark recognizer sends a requestto the door to open
//
// 4. The dog door opens.
// 5. Dog goes outside.
// 6. Dog does his business.
//
//    6.1. The door shuts automatically.
//    6.2. Dog barks to be let back inside.
//    6.3. She/He hears dog barking (again).
//
//         6.3.1 The bark recognizer hears a bark (again).
//
//    6.4. She/He presses the button on the remote control
//
//         6.4.1 The bark recognizer sends a requestto the door to open
//
//    6.5. The dog door opens (again).
//
// 7. Dog goes back inside.
// 8. The door shuts automatically.

public class DogDoorSimulator {

	public static void main(String[] args) {
		DogDoor dogDoor = new DogDoor();
		BarkRecognizer barkRecognizer = new BarkRecognizer(dogDoor);

		// simulate the hardwares hearing a bark
		System.out.println("Dog barks to go outside...");
		barkRecognizer.recognize("Woof");

		System.out.println("\nDog has gone outside...");

		System.out.println("\nDog's all done...");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println();
		}

		System.out.println("...but he's stuck outside!");

		System.out.println("\nDog starts barking...");
		barkRecognizer.recognize("Woof");

		System.out.println("\nDog's back inside...");
	}
}
