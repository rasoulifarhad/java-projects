package com.farhad.example.decorator.beverages;

import lombok.Getter;

public abstract class Beverage {
	@Getter	
	String description = "Unknown Beverage";

	
	public abstract double cost();
}
