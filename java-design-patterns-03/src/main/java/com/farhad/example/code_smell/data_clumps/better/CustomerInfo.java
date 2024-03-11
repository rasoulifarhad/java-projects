package com.farhad.example.code_smell.data_clumps.better;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerInfo {

	private String customerName;
	private String shippingAddress;
	private String billingAddress;
}
