package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;

import lombok.Value;

@Value
public class TaxLineItem {

	private String description;
	private double percentage;
	private Money amount;
}
