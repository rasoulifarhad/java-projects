package com.farhad.example.design_principles02.video_store_demo.demo2.price;

public abstract class Price {

	public abstract double getCharge(int daysRented);

	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}




}
