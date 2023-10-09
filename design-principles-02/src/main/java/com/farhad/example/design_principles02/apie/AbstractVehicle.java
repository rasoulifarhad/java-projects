package com.farhad.example.design_principles02.apie;

public abstract class AbstractVehicle implements VehicleInterface{
	
	public abstract void move();

	public void stop() {
		System.out.println("stopped...");
	}
}
