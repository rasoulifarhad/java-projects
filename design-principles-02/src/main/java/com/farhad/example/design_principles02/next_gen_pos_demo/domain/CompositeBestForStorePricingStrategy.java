package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;
public class CompositeBestForStorePricingStrategy extends CompositeBestForCustomerPricingStrategy {

	@Override
	public Money getTotal(Sale sale) {

		Money highestTotal = Money.of(Integer.MIN_VALUE);
		
		for (SalePricingStrategy s : strategies) {
			Money total = s.getTotal(sale);
			highestTotal = total.greaterThan(highestTotal) ? total : highestTotal;
		}
		return highestTotal;
	}

	
}
