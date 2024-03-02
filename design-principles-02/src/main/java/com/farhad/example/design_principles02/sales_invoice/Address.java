package com.farhad.example.design_principles02.sales_invoice;

import lombok.Value;

@Value
public class Address {

	private String address1;
	private String address2;
	private String state;
	private String city;
	private String zip;

}
