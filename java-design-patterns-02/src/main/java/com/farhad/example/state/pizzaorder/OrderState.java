package com.farhad.example.state.pizzaorder;

public interface OrderState {

	void next(Order order);

	void printStatus();

}
