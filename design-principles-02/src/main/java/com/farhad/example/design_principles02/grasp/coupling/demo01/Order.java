package com.farhad.example.design_principles02.grasp.coupling.demo01;

import lombok.Data;

@Data
public class Order {

	private ShippingProvider shippingProvider;

	public void process() {
		shippingProvider.ship(this);
	}
}
