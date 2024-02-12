package com.farhad.example.design_principles02.DOUG_DOG_D00R.third;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BarkRecognizer {

	private final DogDoor dogDoor;

	// Every time the hardware hears a bark, it will call this method with the sound of the bark it heard
	public void recognize(String bark) {
		System.out.println("   BarkRecognizer: Heard a '" + bark + "'");
		dogDoor.open();
	}
}
