package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.isp.good;

public interface OrderProcessor {

	boolean validateShippingAddress(Address address);

	void processOrder(Order order);
}
