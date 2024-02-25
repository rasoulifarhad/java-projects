package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.isp.good;

public class App {

	public void processOrder(String paymentMode) {

		Customer customer = new Customer("customer01");
		Address address = new Address();
		CreditCardInfo cardInfo = null;

		Order order = new Order("order#01", customer, address, cardInfo);

		if (paymentMode.equals("card")) {
			OnSiteOrderProcessor onSiteOrderProcessor = new OnSiteOrderProcessor();
			cardInfo = new CreditCardInfo("1234567", "12", "2024");
			onSiteOrderProcessor.validateCardInfo(cardInfo);
			onSiteOrderProcessor.validateShippingAddress(address);
			onSiteOrderProcessor.processOrder(order);
		} else {
			CashOnDeliveryOrderProcessor cashOnDeliveryOrderProcessor = new CashOnDeliveryOrderProcessor();
			cashOnDeliveryOrderProcessor.validateShippingAddress(address);
			cashOnDeliveryOrderProcessor.processOrder(order);
		}
		System.out.println("Success: " + order);
	}

}
