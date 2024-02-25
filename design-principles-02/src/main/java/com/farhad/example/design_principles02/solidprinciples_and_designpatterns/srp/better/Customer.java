package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.srp.better;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
	private String customerId;
	private String contactName;
	private String country;
	private String companyName;
}
