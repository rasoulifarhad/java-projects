package com.farhad.example.decorator.beverages;

public class Decaf extends Beverage {

	public Decaf(){
		description = "Decaf caffee";
	}

	@Override
	public double cost() {
		return 1.05;
	}
	
}
