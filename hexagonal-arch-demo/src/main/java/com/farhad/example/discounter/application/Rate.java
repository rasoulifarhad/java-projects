package com.farhad.example.discounter.application;

import java.math.BigDecimal;
import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Rate {
	
	private final Amount amount;

	private Rate(Amount amount) {
		Objects.requireNonNull(amount, "Amount can not be null");
		assert !(amount.isGreaterThan(Amount.parse("1.00"))) : "Amount cannot be greater than one";
		this.amount = amount;
	}

	public static Rate parse(String str) {
		return new Rate(Amount.parse(str));
	}

	public BigDecimal getValue() {
		return this.amount.getValue();
	}


}
