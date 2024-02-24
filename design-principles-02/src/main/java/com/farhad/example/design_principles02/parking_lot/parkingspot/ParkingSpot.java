package com.farhad.example.design_principles02.parking_lot.parkingspot;

import com.farhad.example.design_principles02.apie.Vehicle;

import lombok.Getter;

@Getter
public class ParkingSpot {

	private String number;
	private boolean free;
	private ParkingSpotType type;
	private Vehicle parkedVehicle;
	
	
	public ParkingSpot(String number, ParkingSpotType type) {
		this.number = number;
		this.type = type;
		this.free = true;
		this.parkedVehicle = null;
	}


	public void assignVehicle(Vehicle vehicle) {

		this.parkedVehicle = vehicle;
		this.free = false;
	}

	public void removeVehicle() {
		this.parkedVehicle = null;
		this.free = true;
	}
	public boolean getIsFree() {
		return free;
	}
}
