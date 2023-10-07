package com.farhad.example.ddd_tips.specifications;

public class CustomerService {
	
	public void BuyAlcohol(Customer customer) {

		if(!new Age18PlusCustomerSpecification().isSatisfiedBy(customer)) {
			throw new RuntimeException("This customer doesn't satisfy the Age specification!");
		}
	}
}
