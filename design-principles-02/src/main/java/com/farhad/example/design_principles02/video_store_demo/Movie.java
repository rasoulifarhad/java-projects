package com.farhad.example.design_principles02.video_store_demo;

import lombok.Getter;

@Getter
public abstract class Movie {

	
	private String title;
	private int priceCode;

	public abstract double getCharge(int daysRented);

	public abstract int getFrequentRenterPoints(int daysRented);
}
