package com.farhad.example.design_principles02.another_grasp;

import lombok.Data;

@Data
public class OrderAddedEvent {

	private Order order;

	public OrderAddedEvent(Order order) {
		this.order = order;
	}

}
