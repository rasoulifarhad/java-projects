package com.farhad.example.design_principles02.rock_and_roll.ninth.instrument;

import lombok.Getter;

// apply the ease-of-change test:
//
// - How many classes did you have to add    to support new Instrument type?
// - How many classes did you have to change to support  new Instrument type?
// - suppose that we decided that we wanted to start keeping up with year an instrument was made in.
//   How many classes whould you need to change to support keeping up with this new information?
// - also we want to add a new property, neckWood, that tracks what wood is used in the neck of an 
//   instrument. How many classes whould you need to change to support this property?

public class Instrument {

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
