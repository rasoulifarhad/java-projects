package com.farhad.example.design_principles02.parking_lot.parkingspot;

public class ElectricSpot extends ParkingSpot{


	private ElectricPanel electricPanel;

	public ElectricSpot(String number) {
		super(number, ParkingSpotType.Electric);
	}

}
