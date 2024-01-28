package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.ItemId;
import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class ProductDescription {

	private String description;
	private Money price;
	private ItemId itemId;

}
