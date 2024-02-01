package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;

public class CompositeBestForCustomerPricingStrategy extends CompositePricingStrategy {

	@Override
	public Money getTotal(Sale sale) {

		Money lowestTotal = Money.of(Integer.MAX_VALUE);
		
		for (SalePricingStrategy s : strategies) {
			Money total = s.getTotal(sale);
			lowestTotal = total.lessThan(lowestTotal) ? total : lowestTotal;
		}
		return lowestTotal;
	}


}
