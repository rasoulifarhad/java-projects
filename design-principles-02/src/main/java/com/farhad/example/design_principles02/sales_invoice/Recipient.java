package com.farhad.example.design_principles02.sales_invoice;

import java.util.Date;

import lombok.Data;

@Data
public class Recipient {

	private String name;
	private Address address;
	private Date date;
}
