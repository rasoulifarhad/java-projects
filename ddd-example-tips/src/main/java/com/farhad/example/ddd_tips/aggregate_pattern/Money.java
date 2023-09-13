package com.farhad.example.ddd_tips.aggregate_pattern;

import java.math.BigDecimal;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Money {

	private final BigDecimal amount;

	public Money times(BigDecimal quantity) {
		return new Money(amount.multiply(quantity));
	}	
}
