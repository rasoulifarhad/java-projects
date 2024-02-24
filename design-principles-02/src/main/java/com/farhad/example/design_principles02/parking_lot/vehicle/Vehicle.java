package com.farhad.example.design_principles02.parking_lot.vehicle;

import com.farhad.example.design_principles02.parking_lot.parking.ParkingTicket;

import lombok.Getter;

@Getter
public abstract class Vehicle {

	private String licenseNumber;
	private VehicleType vehicleType;

	private ParkingTicket parkingTicket;

	
	public Vehicle(String licenseNumber, VehicleType vehicleType, ParkingTicket parkingTicket) {
		this.licenseNumber = licenseNumber;
		this.vehicleType = vehicleType;
		this.parkingTicket = parkingTicket;
	}

	public Vehicle(String licenseNumber, VehicleType vehicleType) {
		this(licenseNumber, vehicleType, null);
	}

	public void assignTicket(ParkingTicket parkingTicket) {
		this.parkingTicket = parkingTicket;
	}
}
