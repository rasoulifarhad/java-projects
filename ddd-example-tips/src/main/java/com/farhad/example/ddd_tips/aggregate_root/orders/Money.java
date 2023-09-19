package com.farhad.example.ddd_tips.aggregate_root.orders;

import java.math.BigDecimal;
import java.util.Objects;

import lombok.Value;

@Value
public class Money {

	public static final Money ZERO = new Money(new BigDecimal("0"));

	private final BigDecimal amount;

	public Money(BigDecimal amount) {
		this.amount = Objects.requireNonNull(amount);
	}

	public Money multiply(int quantity) {
		return new Money(amount.multiply(BigDecimal.valueOf(quantity)));
	}

	public Money add(Money other) {
		Objects.requireNonNull(other);
		return new Money(amount.add(other.amount));

	}
}
