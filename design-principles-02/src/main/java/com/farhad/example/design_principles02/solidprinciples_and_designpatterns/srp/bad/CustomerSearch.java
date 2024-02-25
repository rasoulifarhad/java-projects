package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.srp.bad;

import java.util.List;

import lombok.RequiredArgsConstructor;

// There are two possible reasons for changing CustomerSearch 
//
// - change in search functionality and 
// - change in the data-export functionality.

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

	public String exportToCsv(List<Customer> customers) {
		StringBuilder sb = new StringBuilder();
		for (Customer customer : customers) {
			sb.append(String.format("%s,%s,%s,%s", customer.getCustomerId(), customer.getCompanyName(),
					customer.getContactName(), customer.getCountry()));
			sb.append("\n");
		}
		return sb.toString();
	}

	public String exportToXml(List<Customer> customers) {
		throw new UnsupportedOperationException();
	}
}
