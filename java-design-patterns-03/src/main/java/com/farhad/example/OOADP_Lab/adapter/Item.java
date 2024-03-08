package com.farhad.example.OOADP_Lab.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@AllArgsConstructor
public class Item {

	String name;
	
	@Setter
	int qty;
	
	float price;

	@Setter
	CalcTax ct;

	public void displayItem() {
		System.out.println("\nName: " + name);
		System.out.println("Quantity: " + qty);
		System.out.println("Price: " + price);
		float tax = ct.taxAmount(qty, price);
		float billAmount = (qty * price) + tax;
		System.out.println("Tax Amount: " + tax);
		System.out.println("Bill Amount: " + billAmount);
	}

}
