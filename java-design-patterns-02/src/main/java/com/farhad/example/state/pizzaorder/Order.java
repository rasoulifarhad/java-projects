package com.farhad.example.state.pizzaorder;

import lombok.Data;

// Context class
@Data
public class Order {
	
	private OrderState state  = new ConfirmedState();

	public void nextState() {
		state.next(this);
	}

	public void printStatus() {
		state.printStatus();
	}
}
