package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.srp.better;

import java.util.List;

public class CustomerDataExporter {

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
