package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class SalesLineItem {

	private final ProductDescription productDescription;
	private final Integer quantity;

	public static SalesLineItem of(ProductDescription productDescription, Integer quantity) {
		return new SalesLineItem(productDescription, quantity);
	}

	public static SalesLineItem of(ProductDescription productDescription) {
		return new SalesLineItem(productDescription, 1);
	}

	public Money getSubtotal() {
		return productDescription.getPrice().multiply(quantity);
	}

}
