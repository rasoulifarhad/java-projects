package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.srp.better;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerSearch {

	private final CustomerRepository repository;

	public List<Customer> searchByCountry(String country) {
		return repository.byCountry(country);
	}

	public List<Customer> searchByCompanyName(String companyName) {
		return repository.byCompany(companyName);
	}

	public List<Customer> searchByContactName(String contactName) {
		return repository.byContact(contactName);
	}

}
