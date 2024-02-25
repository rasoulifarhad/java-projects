package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.srp.bad;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerApp {

	private final CustomerSearch customerSearch;

	public List<Customer> getData(String criteria, String searchBy) {

		List<Customer> result = null;
		switch (searchBy) {
			case "companyName":
				result = customerSearch.searchByCompanyName(criteria);
				break;
			case "contactName":
				result = customerSearch.searchByContactName(criteria);
				break;
			case "countryName":
				result = customerSearch.searchByCountry(criteria);
				break;

			default:
				throw new IllegalArgumentException("Unknown searchBy: " + searchBy);
		}

		return result;
	}
	
	public String exportCsv(String criteria, String searchBy) {
		List<Customer> customers = getData(criteria, searchBy);
		return customerSearch.exportToCsv(customers);
	}

}
