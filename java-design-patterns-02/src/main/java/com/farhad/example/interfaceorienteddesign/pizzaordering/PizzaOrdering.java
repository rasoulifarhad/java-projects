package com.farhad.example.interfaceorienteddesign.pizzaordering;

import java.time.Period;

public interface PizzaOrdering {
	
	enum Size {SMALL, MEDIUM, LARGE}
	enum Toppings {PEPERONI, MUSHROOMS, PEPPERS, SAUSAGE}

	void setSize(Size size);
	void setToppings(Toppings toppings);
	void setAddress(String streetAddress);
	Period getTimeTillDelivered();
}
