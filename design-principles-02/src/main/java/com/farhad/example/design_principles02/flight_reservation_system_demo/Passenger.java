package com.farhad.example.design_principles02.flight_reservation_system_demo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Passenger {

	int id;
	int idCounter = 0;
	private Ticket ticket;
	private Contact contact;
	private Address address;

	public Passenger(int id, String name, String phone, String email, String street, String city, String state) {
		this.id = ++idCounter;
		this.contact = new Contact(name, phone, email);
		this.address = new Address(street, city, state);
	}
	
	public int getPassengerCount() {
		return idCounter;
	}

	@AllArgsConstructor
	@Getter
	private static class  Contact {
	
		String name;
		String phone;
		String email;

		
		public void updateContactDetails(String name, String phone, String email) {
			this.name = name;
			this.phone = phone;
			this.email = email;
		}


	}


	@AllArgsConstructor
	@Getter
	private static class Address {

		String street;
		String city;
		String state;

		public void updateAddressDetails(String street, String city, String state) {
			this.street = street;
			this.city = city;
			this.state = state;
		}

	}
	
	public String getAddressDetails() {
		return "Street: " + address.street + "City: " + address.city + "State: " + address.state;
	}

	public String getContactDetails() {
		return "Name: " + contact.name + "Phone: " + contact.phone + "Email: " + contact.email;
	}	
}
