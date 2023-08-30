package com.farhad.example.interfaceorienteddesign.pizzaordering;

public interface PizzaOrderingFinder {
	
	PizzaOrdering findImplementationByName(String nameOfPizzaShop);
	PizzaOrdering findFirstImplementation();
	PizzaOrdering findDefaultImplementation();
}
