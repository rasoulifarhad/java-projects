package com.farhad.example.design_principles02.another_grasp;

public class OrderRemovedEvent {


	private Order order;

	public OrderRemovedEvent(Order order) {
		this.order = order;
	}

}
