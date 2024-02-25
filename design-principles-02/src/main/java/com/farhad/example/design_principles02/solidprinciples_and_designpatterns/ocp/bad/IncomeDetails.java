package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.ocp.bad;

import lombok.Value;

@Value
public class IncomeDetails {

	private double totalIncome;
	private double totalDeduction;
	private String country;

}
