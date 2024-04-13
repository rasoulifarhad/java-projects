package com.farhad.example.design_principles02.video_store_demo;

public class RegularMovie extends Movie {

	@Override
	public double getCharge(int daysRented) {
		double thisAmount = 2;
		if (daysRented > 2) {
			thisAmount += (daysRented - 2) * 1.5;
		}
		return thisAmount;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}


}
