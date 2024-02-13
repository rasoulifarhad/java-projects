package com.farhad.example.design_principles02.DOUG_DOG_D00R.fifth;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BarkRecognizer {

	private final DogDoor dogDoor;

	// Every time the hardware hears a bark, it will call this method with the sound of the bark it heard
	// public void recognize(String bark) {
	// 	System.out.println("   BarkRecognizer: Heard a '" + bark + "'");
	// 	if (dogDoor.getAllowedBark().equals(bark)) {
	// 		dogDoor.open();
	// 	} else {
	// 		System.out.println("This dog is not allowed.");
	// 	}
	// }

	public void recognize(Bark bark) {
		System.out.println("   BarkRecognizer: Heard a '" + bark.getSound() + "'");
		List<Bark> allowedBarks = dogDoor.getAllowedBarks();
		for (Bark b : allowedBarks) {
			if (b.equals(bark)) {
				dogDoor.open();
				return;
			}
		}
		System.out.println("This dog is not allowed.");

	}

}
