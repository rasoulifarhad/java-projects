package com.farhad.example.ddd_tips.specifications;

public class Age18PlusCustomerSpecification extends AbstractSpecification<Customer>{

	@Override
	public boolean isSatisfiedBy(Customer t) {
		return t.getAge() > 18;
	}
	
}
