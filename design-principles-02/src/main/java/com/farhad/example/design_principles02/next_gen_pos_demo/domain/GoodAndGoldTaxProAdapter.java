package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import java.util.ArrayList;
import java.util.List;

public class GoodAndGoldTaxProAdapter implements TaxCalculatorAdapter {

	@Override
	public List<TaxLineItem> getTaxes(Sale sale) {
		return new ArrayList<>();
	}

}
