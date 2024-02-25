package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.isp.bad;

import lombok.Value;

@Value
public class Order {

	private String orderId;
	private Customer customer;
	private Address shippingAddress;
	private CreditCardInfo cardInfo;
}
