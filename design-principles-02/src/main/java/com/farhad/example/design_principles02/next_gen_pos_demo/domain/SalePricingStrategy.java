package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;

public interface SalePricingStrategy {

	Money getTotal(Sale sale);
}
