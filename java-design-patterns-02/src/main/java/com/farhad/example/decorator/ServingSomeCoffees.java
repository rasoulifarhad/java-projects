package com.farhad.example.decorator;

import com.farhad.example.decorator.beverages.Beverage;
import com.farhad.example.decorator.beverages.DarkRoast;
import com.farhad.example.decorator.beverages.Espresso;
import com.farhad.example.decorator.beverages.HouseBlend;
import com.farhad.example.decorator.decorators.Mocha;
import com.farhad.example.decorator.decorators.Soy;
import com.farhad.example.decorator.decorators.Whip;

public class ServingSomeCoffees {
	
	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.out.println(String.format("%s $%.2f", beverage.getDescription(), beverage.cost())); 

		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(String.format("%s $%.2f", beverage2.getDescription(), beverage2.cost())); 

		Beverage beverage3 = new HouseBlend();
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(String.format("%s $%.2f", beverage3.getDescription(), beverage3.cost())); 
	}
}
