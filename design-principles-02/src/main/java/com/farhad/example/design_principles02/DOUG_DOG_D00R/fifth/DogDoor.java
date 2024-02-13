package com.farhad.example.design_principles02.DOUG_DOG_D00R.fifth;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import lombok.Getter;
import lombok.Setter;

public class DogDoor {

	private boolean open;

	// @Getter
	// @Setter
	// private String AllowedBark;

	@Getter
	@Setter
	private List<Bark> allowedBarks;
	public DogDoor() {
		this.open = false;
		this.allowedBarks = new ArrayList<>();
	}

	public void open() {
		System.out.println("The dog door opens.");
		this.open = true;

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				close();
				timer.cancel();
			}
			
		},5000);
	}

	public void close() {
		System.out.println("The dog door closes");
		this.open = false;
	}

	public boolean isOpen() {
		return open;
	}
	
	public void addAllowedBark(Bark bark) {
		allowedBarks.add(bark);
	}

	public List<Bark> getAlowedBarks() {
		return allowedBarks;
	}
	
}
