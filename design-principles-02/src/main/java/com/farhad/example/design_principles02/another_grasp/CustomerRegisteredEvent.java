package com.farhad.example.design_principles02.another_grasp;

import lombok.Data;

@Data
public class CustomerRegisteredEvent {

	private Customer customer;

	public CustomerRegisteredEvent(Customer customer) {
		this.customer = customer;
	}

}
