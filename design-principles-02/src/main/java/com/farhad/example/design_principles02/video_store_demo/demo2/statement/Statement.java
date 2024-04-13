package com.farhad.example.design_principles02.video_store_demo.demo2.statement;

import com.farhad.example.design_principles02.video_store_demo.demo2.Customer;
import com.farhad.example.design_principles02.video_store_demo.demo2.Rental;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public abstract class Statement {

	final Customer customer;

	public abstract String generate();

	int getTotalFrequentRenterPoints() {
		int total = 0;
		for (Rental rental : customer.getRentals()) {
			total += rental.getFrequentRenterPoints();
		}
		return total;
	}

	double getTotalCharge() {
		double totalAmount = 0;
		for (Rental rental : customer.getRentals()) {
			totalAmount += rental.getCharge();
		}
		return totalAmount;
	}

}
