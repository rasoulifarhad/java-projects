package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.isp.bad;

// Suppose you are developing an e-commerce website that needs to have a shopping cart and associated order-processing mechanism.
// Initially we think that the application will accept only online payments through credit cards.
//
// - ValidateCardInfo() is intended to validate the credit card information,such as card number and expiration date.
// - The ValidateShippingAddress() method is intended to validate a shipping destination.This might be necessary to 
//    ensure that the shipping destination is within the service area of the company.
// - Finally, ProcessOrder() is intended to initiate order processing by placing the order in the system.
public class App {

	public void processOrder(String paymentMode) {

		Customer customer = new Customer("customer01");
		Address address = new Address();
		CreditCardInfo cardInfo = null;

		Order order = new Order("order#01", customer, address, cardInfo);

		if (paymentMode.equals("card")) {
			OnlineOrderProcessor onlineOrderProcessor = new OnlineOrderProcessor();
			cardInfo = new CreditCardInfo("1234567", "12", "2024");
			onlineOrderProcessor.validateCardInfo(cardInfo);
			onlineOrderProcessor.validateShippingAddress(address);
			onlineOrderProcessor.processOrder(order);
		} else {
			CashOnDeliveryOrderProcessor cashOnDeliveryOrderProcessor = new CashOnDeliveryOrderProcessor();
			cashOnDeliveryOrderProcessor.validateShippingAddress(address);
			cashOnDeliveryOrderProcessor.processOrder(order);
		}
		System.out.println("Success: " + order);
	}

}
