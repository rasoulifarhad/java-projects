package com.farhad.example.design_principles02.clean_code.isolating_change.better;

import lombok.Value;

@Value
public class Money {

	private final double value;

	public Money factor(int factor) {
		return new Money(value * factor);
	}
}
