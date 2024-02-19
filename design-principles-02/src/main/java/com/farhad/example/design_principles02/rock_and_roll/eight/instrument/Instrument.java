package com.farhad.example.design_principles02.rock_and_roll.eight.instrument;

import lombok.Getter;

// Classes are really about behavior, guitar, mandolin, and the other instruments do'nt have 
// different behavior. but they have different properties...so we have to have subclasses for 
// each instrument. right?
// 
// because instrument class represents a concept , and not an actual object, it really should be abstract.
// so we have to have subclasses for each instrument type.
//
// each different type  of instrument has different properties, and uses a different subclass of 
// instrumentSpec, so we need an instrument -spwcific constructor for each type of instrument.
//
// When you do'nt know what to do to solve a design problem, just run through the OO principles 
// you know, and see if any of them might help improve your software's design.
//
// - Inheritance
// - Polymorphism
// - Abstraction
// - Encapsulation(encapsulate what varies) - since the properties in each instrument type are what varies.
//                                            can we somehow encapsulate those properties away fro instrument
//                                            and instrumentSpec completely?

public class Instrument {

	@Getter
	private InstrumentType instrumentType;
	@Getter
	private String serialNumbeer;

	@Getter
	private double price;

	@Getter
	private InstrumentSpec spec;
	
	public Instrument(InstrumentType instrumentType, String serialNumbeer, double price, InstrumentSpec spec) {
		this.serialNumbeer = serialNumbeer;
		this.price = price;
		this.spec = spec;
	}
}
