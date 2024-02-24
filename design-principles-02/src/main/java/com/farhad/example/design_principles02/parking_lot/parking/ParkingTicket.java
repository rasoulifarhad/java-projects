package com.farhad.example.design_principles02.parking_lot.parking;

import java.time.Instant;

import lombok.Getter;

@Getter
public class ParkingTicket {

	private String ticketNumber;
	private Instant issuedAt;
	private Instant payedAt;
	private double payedAmount;
	private ParkingTicketStatus status;
	public void saveInDb() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'saveInDb'");
	}
}
