package com.farhad.example.ddd_tips.aggregate_root.orders;

import java.util.UUID;

import com.farhad.example.ddd_tips.aggregate_root.orders.Customer.CustomerId;

import lombok.RequiredArgsConstructor;
import lombok.Value;


public class Customer extends AggregateRoot<CustomerId>{
	
	public Customer(CustomerId id) {
		super(id);
	}

	@RequiredArgsConstructor
	@Value
	public static class CustomerId {
		private final String id;

		public static CustomerId createRandomUnique() {
			return new CustomerId(UUID.randomUUID().toString());
		}

	}

	public String getName() {
		return null;
	}

	public PostalAddress getAddress() {
		return null;
	}
}
