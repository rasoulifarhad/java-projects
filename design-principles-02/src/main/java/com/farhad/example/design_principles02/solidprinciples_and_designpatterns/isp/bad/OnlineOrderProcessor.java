package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.isp.bad;

public class OnlineOrderProcessor implements OrderProcessor {

	@Override
	public boolean validateCardInfo(CreditCardInfo cardInfo) {
		return true;
	}

	@Override
	public boolean validateShippingAddress(Address address) {
		return true;
	}

	@Override
	public void processOrder(Order order) {
	}
	
}
