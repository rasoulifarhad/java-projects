package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PercentDiscountPricingStrategy implements SalePricingStrategy {

	private final double percentage;
	@Override
	public Money getTotal(Sale sale) {

		return sale.getPreDiscountTotal().mul(percentage);
	}

}
