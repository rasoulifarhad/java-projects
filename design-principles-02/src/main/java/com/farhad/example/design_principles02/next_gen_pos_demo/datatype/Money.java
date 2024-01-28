package com.farhad.example.design_principles02.next_gen_pos_demo.datatype;

import java.math.BigDecimal;

import lombok.Getter;

public class Money {

	@Getter
	private BigDecimal value;

	private Money(BigDecimal value) {
		this.value = value;
	}

	public static Money of(String stringValue) {
		return new Money(new BigDecimal(stringValue));
	}

	public Money add(Money money) {
		return new Money(value.add(money.getValue()));
	}
	
	public Money multiply(int factor) {
		return new Money(value.multiply(BigDecimal.valueOf(factor)));
	}

	public Money sub(Money money) {
		return new Money(value.min(money.getValue()));
	} 
}
