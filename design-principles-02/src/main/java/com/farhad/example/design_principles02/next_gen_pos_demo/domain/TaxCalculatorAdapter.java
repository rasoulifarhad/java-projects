package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import java.util.List;

public interface TaxCalculatorAdapter {
	List<TaxLineItem> getTaxes(Sale sale);
}
