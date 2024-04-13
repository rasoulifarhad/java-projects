package com.farhad.example.design_principles02.video_store_demo;

public class ChildrensMoview extends Movie {

	@Override
	public double getCharge(int daysRented) {
		double thisAmount = 1.5;
		if (daysRented > 3) {
			thisAmount += (daysRented - 3) * 1.5;
		}
		return thisAmount;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}


}
