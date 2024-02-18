package com.farhad.example.design_principles02.rock_and_roll.sixth;

import lombok.Getter;


public abstract class Instrument {

	@Getter
	private String serialNumbeer;

	@Getter
	private double price;

	@Getter
	private InstrumentSpec spec;
	
	public Instrument(String serialNumbeer, double price, InstrumentSpec spec) {
		this.serialNumbeer = serialNumbeer;
		this.price = price;
		this.spec = spec;
	}
}
