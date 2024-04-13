package com.farhad.example.design_principles02.video_store_demo.demo2;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Customer {

	@Getter
	private final String name;

	@Getter
	private List<Rental> rentals = new ArrayList<>();
	
	public void addRental(Rental rental) {
		rentals.add(rental);
	}

}
