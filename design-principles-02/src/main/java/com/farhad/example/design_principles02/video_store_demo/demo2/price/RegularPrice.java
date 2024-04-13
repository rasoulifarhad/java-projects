package com.farhad.example.design_principles02.video_store_demo.demo2.price;

public class RegularPrice extends Price {

	@Override
	public double getCharge(int daysRented) {
		return daysRented > 2 ? 2 + ((daysRented -2) * 1.5) : 2; 
	}

}
