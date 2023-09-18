package com.farhad.example.decorator.decorators;

import com.farhad.example.decorator.beverages.Beverage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Whip extends CondimentDecorator {

	Beverage beverage;

	@Override
	public double cost() {
		return 0.10 + beverage.cost();
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
	
}
