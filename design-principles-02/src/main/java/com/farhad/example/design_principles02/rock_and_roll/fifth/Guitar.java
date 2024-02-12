package com.farhad.example.design_principles02.rock_and_roll.fifth;

import lombok.Data;

@Data
public class Guitar {

	private String serialNumbeer;
	private double price;
	private GuitarSpec guitarSpec;

	public Guitar(String serialNumbeer, double price, GuitarSpec guitarSpec) {
		this.serialNumbeer = serialNumbeer;
		this.price = price;
		this.guitarSpec = guitarSpec;
	}
	
}
