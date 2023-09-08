package com.farhad.example.state.pizzaorder;

public class OrderClient {
	
	public static void main(String[] args) {
		Order order = new Order();
		order.printStatus();

		order.nextState();
		order.printStatus();

		order.nextState();
		order.printStatus();

		order.nextState();
		order.printStatus();
	}
}
