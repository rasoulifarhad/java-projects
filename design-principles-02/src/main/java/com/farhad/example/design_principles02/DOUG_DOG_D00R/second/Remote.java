package com.farhad.example.design_principles02.DOUG_DOG_D00R.second;

import java.util.Timer;
import java.util.TimerTask;

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
			final Timer timer = new Timer();
			timer.schedule(new TimerTask() {

				@Override
				public void run() {
					door.close();
					timer.cancel();
				}

			}, 5000);
		}
	}
}