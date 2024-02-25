package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.srp.better;

import java.util.List;

public interface CustomerRepository {

	void save(Customer customer);
	List<Customer> byCountry(String country);

	List<Customer> byCompany(String countryName);

	List<Customer> byContact(String contactName);
}
