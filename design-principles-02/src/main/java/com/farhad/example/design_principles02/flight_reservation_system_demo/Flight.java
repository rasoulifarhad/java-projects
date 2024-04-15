package com.farhad.example.design_principles02.flight_reservation_system_demo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Flight {

	private String flightNumber;
	private String airline;
	private int capacity;
	private int bookedSeats;


	public String checkAvailability() {
		if (this.bookedSeats < capacity) {
			return "Available";
		} else {
			return "Not Available";
		}
	}

	public void incrementBookingCounter() {
		bookedSeats++;
	}
}
