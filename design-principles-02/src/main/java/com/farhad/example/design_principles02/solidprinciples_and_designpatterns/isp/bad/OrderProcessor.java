package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.isp.bad;

public interface OrderProcessor {

	boolean validateCardInfo(CreditCardInfo cardInfo);

	boolean validateShippingAddress(Address address);

	void processOrder(Order order);
}
