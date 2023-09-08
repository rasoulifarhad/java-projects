package com.farhad.example.state.pizzaorder;

public class BakedState implements OrderState {

	@Override
	public void next(Order order) {
		order.setState(new DispatchedState());
	}

	@Override
	public void printStatus() {
		System.out.println("Order baked.");
	}

}
