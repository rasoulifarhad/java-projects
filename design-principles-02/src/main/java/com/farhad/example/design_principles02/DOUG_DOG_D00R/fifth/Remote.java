package com.farhad.example.design_principles02.DOUG_DOG_D00R.fifth;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Remote {

	private final DogDoor door;

	public void pressButton() {
		System.out.println("Pressing the remote control button ...");
		if (door.isOpen()) {
			door.close();
		} else {
			door.open();
		}
	}
}