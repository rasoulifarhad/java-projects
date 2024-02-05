package com.farhad.example.design_principles02.another_grasp;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class Order {

	private UUID id;

	public boolean isOrderedToday() {
		return true;
	}

	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'remove'");
	}

	public void change(List<OrderProduct> products, List<ConversionRate> conversionRates) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'change'");
	}

}
