package com.farhad.example.state.pizzaorder;

public class DeliveredState implements OrderState {

	@Override
	public void next(Order order) {
		order.setState(null);
	}

	@Override
	public void printStatus() {
		System.out.println("Order delivered");
	}

}
