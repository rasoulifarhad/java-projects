package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.isp.good;

public class CashOnDeliveryOrderProcessor implements OrderProcessor {

	@Override
	public boolean validateShippingAddress(Address address) {
		return true;
	}

	@Override
	public void processOrder(Order order) {
	}

}
