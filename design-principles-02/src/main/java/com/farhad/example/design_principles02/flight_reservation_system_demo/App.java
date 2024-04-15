package com.farhad.example.design_principles02.flight_reservation_system_demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {

	public static void main(String[] args) {
		Passenger passenger = new Passenger(121, "Ram", "9123456789", "ram@yahoo.com",
				"Nehru street", "Bangalore", "karnataka");
		Flight flight = new Flight("se123", "Indigo", 150, 10);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		RegularTicket regularTicket = new RegularTicket("199212", "BLR", "CBE", 
				LocalDate.parse("01-01-2020", formatter).atStartOfDay(),
				LocalDate.parse("01-01-2020", formatter).atStartOfDay(),
				"s12", (float) 4500.0, false, flight, passenger, "Foods");
		String hotelAddress = "near church park,Gandhi nagar,Coimbatore";
		String[] locations = { "Ooty", "Munnar", "Yercaud" };

		TouristTicket touristTicket = new TouristTicket("151263", "BLR", "CBE",
				LocalDate.parse("01-01-2020", formatter).atStartOfDay(),
				LocalDate.parse("01-01-2020", formatter).atStartOfDay(),
				"H101", 8200.0f, false, flight, passenger, hotelAddress, locations);
		printTicketDetails(regularTicket);
		printTicketDetails(touristTicket);
	}

	public static void printTicketDetails(Ticket ticket) {
		System.out.println("PNR NO:" + ticket.getPnr()); // Prints the PNR number from the ticket class
	}	
}
