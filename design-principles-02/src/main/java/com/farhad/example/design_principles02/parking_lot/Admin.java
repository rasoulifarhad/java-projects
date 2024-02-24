package com.farhad.example.design_principles02.parking_lot;

import com.farhad.example.design_principles02.parking_lot.parking.EntrancePannel;
import com.farhad.example.design_principles02.parking_lot.parking.ExitPannel;
import com.farhad.example.design_principles02.parking_lot.parking.ParkingFloor;
import com.farhad.example.design_principles02.parking_lot.parking.ParkingLot;
import com.farhad.example.design_principles02.parking_lot.parkingspot.ParkingSpot;

public class Admin extends Account {

	public Admin(String userName, String password, Person person, AccountStatus status) {
		super(userName, password, person, status);
	}

	public void addParkingFloor(ParkingLot parkingLot, ParkingFloor parkingFloor) {
		parkingLot.addParkingFloor(parkingFloor);
	}

	public void addParkingSpot(ParkingLot parkingLot, String floorName, ParkingSpot spot) {
		
		parkingLot.addParkingSpot(floorName, spot);
	}

	public void addEntrancePanel(ParkingLot parkingLot, EntrancePannel entrancePannel) {

		parkingLot.addEntrancePanel(entrancePannel);
	}

	public void addExitPanel(ParkingLot parkingLot, ExitPannel exitPannel) {
		parkingLot.addExitPanel(exitPannel);
	}
}
