package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.isp.good;

import lombok.Value;

@Value
public class CreditCardInfo {

	private String cardNo;
	private String expiryMonth;
	private String expiryYear;

}
