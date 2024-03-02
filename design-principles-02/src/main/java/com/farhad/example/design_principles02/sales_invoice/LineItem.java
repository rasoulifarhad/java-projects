package com.farhad.example.design_principles02.sales_invoice;

import lombok.Data;

@Data
public class LineItem {

	private String itemId;
	private int qty;
	private String description;
	private double price;

	public double totsl() {
		return price * qty;
	}
}
