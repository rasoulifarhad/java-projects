package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import java.util.ArrayList;
import java.util.List;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;

import lombok.Getter;

@Getter
public class CompositePricingStrategy implements SalePricingStrategy {

	protected List<SalePricingStrategy> strategies;

	

	public CompositePricingStrategy() {
		strategies = new ArrayList<>();
	}

	@Override
	public Money getTotal(Sale sale) {
		return null;
	}

	public void add(SalePricingStrategy pricingStrategy) {
		strategies.add(pricingStrategy);
	}
}
