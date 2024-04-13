package com.farhad.example.design_principles02.video_store_demo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class Customer {

	@Getter
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public String statement() {


		String result = "Rental record for " + getName() + "\n";
		for (Rental rental : rentals) {
			//show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned  " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}
	
	private double getTotalAmount() {
		double totalAmount = 0;
		for (Rental rental : rentals) {
			totalAmount += rental.getCharge();
		}
		return totalAmount;
	}

	private int getTotalFrequentRenterPoints() {
		int total = 0;
		for (Rental rental : rentals) {
			
			total += rental.getFrequentRenterPoints(); 
		}
		return total;
	}

}
