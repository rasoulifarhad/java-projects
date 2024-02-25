package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.srp.bad;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepositoryStub implements CustomerRepository {

	private final static Map<String, Customer> customers = new HashMap<>();

	@Override
	public List<Customer> byCountry(String country) {
		return customers.values()
				.stream()
				.filter(c -> c.getCountry().equals(country))
				.collect(toList());
	}

	@Override
	public List<Customer> byCompany(String companyName) {
		return customers.values()
				.stream()
				.filter(c -> c.getCompanyName().equals(companyName))
				.collect(toList());
	}

	@Override
	public List<Customer> byContact(String contactName) {
		return customers.values()
				.stream()
				.filter(c -> c.getContactName().equals(contactName))
				.collect(toList());
	}

	@Override
	public void save(Customer customer) {
		customers.put(customer.getCustomerId(), customer);
	}

}
