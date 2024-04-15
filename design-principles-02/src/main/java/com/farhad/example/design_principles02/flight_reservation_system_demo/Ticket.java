package com.farhad.example.design_principles02.flight_reservation_system_demo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Ticket {

	String pnr;
	String from;
	String to;
	LocalDateTime departureTime;
	LocalDateTime arrivalTime;
	String seatNumber;
	float price;
	boolean canceled;
	private Flight flight;
	private Passenger passenger;


	public int getFlightDuration() {
		int days = arrivalTime.getDayOfMonth() - departureTime.getDayOfMonth();
		return (days * 24) + (arrivalTime.getHour() - departureTime.getHour());
	}

}
