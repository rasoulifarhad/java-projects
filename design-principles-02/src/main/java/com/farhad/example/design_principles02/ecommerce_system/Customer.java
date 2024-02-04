package com.farhad.example.design_principles02.ecommerce_system;

import lombok.Data;

@Data
public class Customer {

	private AddressVerification addressVerification;
	private WelcomeEmail welcomeEmail;

	public void addCustomer() {

	}
}
