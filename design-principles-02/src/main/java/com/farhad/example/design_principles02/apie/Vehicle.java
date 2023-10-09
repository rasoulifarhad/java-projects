package com.farhad.example.design_principles02.apie;

public class Vehicle {
	
	private boolean moving;

	public void move() {
		this.moving = true;
		System.out.println("moving...");
	}

	public void stop() {
		this.moving = false;
		System.out.println("stopped...");
	}

}
