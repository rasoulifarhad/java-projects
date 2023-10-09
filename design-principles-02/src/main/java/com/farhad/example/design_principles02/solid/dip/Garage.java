package com.farhad.example.design_principles02.solid.dip;

import java.util.ArrayList;
import java.util.List;

interface Vehicle{}
class Car implements Vehicle{}
class SportCar extends Car {}
class Truck implements Vehicle{}
class Bus implements Vehicle{}

public class Garage {

	List<Vehicle> parkingSpots = new ArrayList<>();

	public void park(Vehicle vehicle) {
		parkingSpots.add(vehicle);
	}
}
