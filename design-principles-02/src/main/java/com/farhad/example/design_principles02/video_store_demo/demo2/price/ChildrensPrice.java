package com.farhad.example.design_principles02.video_store_demo.demo2.price;

public class ChildrensPrice extends Price {

	@Override
	public double getCharge(int daysRented) {
		double result = 1.5;

		if (daysRented > 3) {
			result += (daysRented - 3) * 1.5;
		}

		return result;	}

}
