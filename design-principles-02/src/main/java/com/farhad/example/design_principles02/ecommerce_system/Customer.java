package com.farhad.example.design_principles02.ecommerce_system;

public class Customer extends java.util.Observable {


	public void addCustomer() {
		notifyObservers();
	}
}
