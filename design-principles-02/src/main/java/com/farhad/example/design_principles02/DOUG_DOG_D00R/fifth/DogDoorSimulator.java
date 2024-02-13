package com.farhad.example.design_principles02.DOUG_DOG_D00R.fifth;

//
// 1. The owner's Dog barks to be let out
// 2. The bark recognizer hears a bark
//
//    2.1 The owner hears her dog barking.
//
// 3. If it's the owner's dog barking, the bark recognizer sends a requestto the door to open
//
//    3.1 The owner presses  the button on the remote control.
//
// 4. The dog door opens.
// 5. The owner's Dog goes outside.
// 6. The owner's Dog does his business.
//
//    6.1. The door shuts automatically.
//    6.2. The owner's Dog barks to be let back inside.
//    6.3. She/He hears dog barking (again).
//
//         6.3.1 The owner hears her dog barking (again).
//
//    6.4. if it's the owner's dog barking, the bark recognizer send a request to the door  to open.
//
//         6.4.1 The owner presses the buttun on the remote control.
//
//    6.5. The dog door opens (again).
//
// 7. The owner's Dog goes back inside.
// 8. The door shuts automatically.

public class DogDoorSimulator {

	public static void main(String[] args) {
		DogDoor dogDoor = new DogDoor();
		dogDoor.addAllowedBark(new Bark("rowlf"));
		dogDoor.addAllowedBark(new Bark("rooowlf"));
		dogDoor.addAllowedBark(new Bark("rawlf"));
		dogDoor.addAllowedBark(new Bark("woof"));
		BarkRecognizer barkRecognizer = new BarkRecognizer(dogDoor);
		Remote remote = new Remote(dogDoor);

		// simulate the hardwares hearing a bark
		System.out.println("Dog starts barking.");
		barkRecognizer.recognize( new Bark("rowlf"));

		System.out.println("\nDog has gone outside...");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println();
		}

		System.out.println("\nDog's all done...");
		System.out.println("...but he's stuck outside!");

		// simulate  the hardware hearing a bark (not dog)
		Bark smallDogBbark = new Bark("yip");
		System.out.println("A small dog starts barking.");
		barkRecognizer.recognize(smallDogBbark);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

		// simulate the hardware hearing a bark again
		System.out.println("\nDog starts barking...");
		barkRecognizer.recognize(new Bark("rooowlf"));

		System.out.println("\nDog's back inside...");
	}
}
