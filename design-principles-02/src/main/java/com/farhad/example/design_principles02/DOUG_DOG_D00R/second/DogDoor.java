package com.farhad.example.design_principles02.DOUG_DOG_D00R.second;

public class DogDoor {

	private boolean open;

	public DogDoor() {
		this.open = false;
	}

	public void open() {
		System.out.println("The dog door opens.");
		this.open = true;
	}

	public void close() {
		System.out.println("The dog door closes");
		this.open = false;
	}

	public boolean isOpen() {
		return open;	
	}
	
}
