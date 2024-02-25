package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.isp.bad;

public class CashOnDeliveryOrderProcessor implements OrderProcessor {

	@Override
	public boolean validateCardInfo(CreditCardInfo cardInfo) {
		throw new UnsupportedOperationException("Unimplemented method 'validateCartInfo'");
	}

	@Override
	public boolean validateShippingAddress(Address address) {
		return true;
	}

	@Override
	public void processOrder(Order order) {
	}

}
