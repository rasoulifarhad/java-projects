package com.farhad.example.ddd_tips.vclue_objects.money;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

import lombok.Value;

@Value
public class Money implements Serializable, Comparable<Money>{

	private final BigDecimal amount;
	private final Currency currency;

	

	public Money(BigDecimal amount, Currency currency) {
		this.amount = Objects.requireNonNull(amount);
		this.currency = Objects.requireNonNull(currency);
	}

	public Money add(Money other) {
		assertSameCurrency(other);
		return new Money(amount.add(other.amount), this.currency);
	}

	public Money subtract(Money other) {
		assertSameCurrency(other);
		return new Money(amount.subtract(other.amount), currency);
	}

	private void assertSameCurrency(Money other) {
		if(!other.currency.equals(this.currency)) {
			throw new IllegalArgumentException("Money objects must have the same currency");
		}
	}

	@Override
	public int compareTo(Money other) {
		assertSameCurrency(other);
		return amount.compareTo(other.amount);
	}
	
}
