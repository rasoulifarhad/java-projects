package com.farhad.example.design_principles02.parking_lot;

import com.farhad.example.design_principles02.parking_lot.parking.ParkingTicket;

public class ParkingAttendant extends Account {

	public ParkingAttendant(String userName, String password, Person person, AccountStatus status) {
		super(userName, password, person, status);
	}

	public boolean processTicket(ParkingTicket parkingTicket) {
		return true;
	}

}
