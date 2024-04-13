package com.farhad.example.design_principles02.video_store_demo.demo2;

import com.farhad.example.design_principles02.video_store_demo.demo2.price.ChildrensPrice;
import com.farhad.example.design_principles02.video_store_demo.demo2.price.NewReleasePrice;
import com.farhad.example.design_principles02.video_store_demo.demo2.price.Price;
import com.farhad.example.design_principles02.video_store_demo.demo2.price.RegularPrice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private final String title;
	private Price price;

	

	public Movie(String title, PriceCode priceCode) {
		this.title = title;
		setPriceCode(priceCode);
	}

	public int getFrequentRenterPoints(int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}

	public double getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}
	
	private void setPriceCode(PriceCode priceCode) {
		switch (priceCode) {
			case CHILDRENS:
				price = new ChildrensPrice();
				break;
			case NEW_RELEASE:
				price = new NewReleasePrice();
				break;
			case REGULAR:
				price = new RegularPrice();
				break;
		}
	}
}
