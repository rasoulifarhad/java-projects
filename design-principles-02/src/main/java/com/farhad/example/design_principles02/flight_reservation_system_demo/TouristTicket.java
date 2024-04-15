package com.farhad.example.design_principles02.flight_reservation_system_demo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TouristTicket extends Ticket {

	String hotelAddress;
	String[] selectedTouristLocation = new String[5];

	public TouristTicket(String pnr, String from, String to, LocalDateTime departureTime, LocalDateTime arrivalTime,
			String seatNumber, float price, boolean canceled, Flight flight, Passenger passenger, String hotelAddress, 
			String[] selectedTouristLocation) {
		super(pnr, from, to, departureTime, arrivalTime, seatNumber, price, canceled, flight, passenger);
		this.hotelAddress = hotelAddress;
		this.selectedTouristLocation = selectedTouristLocation;	
	}

}
