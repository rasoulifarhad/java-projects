package com.farhad.example.ddd_tips.jmolecules_order_demo.domain.model.customers;

import java.util.UUID;

public class Customer {
	
	private CustomerId id;


	public static class CustomerId {

		private UUID id;
	}
}
