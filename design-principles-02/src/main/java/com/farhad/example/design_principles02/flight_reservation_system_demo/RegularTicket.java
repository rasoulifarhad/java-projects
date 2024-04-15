package com.farhad.example.design_principles02.flight_reservation_system_demo;

import java.time.LocalDateTime;

public class RegularTicket extends Ticket {

	String specialServices;

	public RegularTicket(String pnr, String from, String to, LocalDateTime departureTime, LocalDateTime arrivalTime,
			String seatNumber, float price, boolean canceled, Flight flight, Passenger passenger, 
			String specialServices) {
		super(pnr, from, to, departureTime, arrivalTime, seatNumber, price, canceled, flight, passenger);
		this.specialServices = specialServices;
	}

	public void updateSpecialServices(String specialServices) {
		this.specialServices = specialServices;
	}

}
