package com.farhad.example.state.pizzaorder;

public class ConfirmedState implements OrderState {

	@Override
	public void next(Order order) {
		order.setState(new BakedState());
	}

	@Override
	public void printStatus() {
		System.out.println("Order confirmed.");
	}
	
}
