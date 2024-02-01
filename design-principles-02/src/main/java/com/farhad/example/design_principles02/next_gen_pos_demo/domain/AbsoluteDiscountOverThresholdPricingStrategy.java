package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbsoluteDiscountOverThresholdPricingStrategy implements SalePricingStrategy {

	private final Money discount;
	private final Money threshold;
	@Override
	public Money getTotal(Sale sale) {

		Money pdt = sale.getPreDiscountTotal();
		if (pdt.lessThan(threshold)) {
			return pdt;
		} else {
			return pdt.mul(discount);
		}
	}

}
