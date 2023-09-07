package com.farhad.example.discounter.application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

// @ToString(onlyExplicitlyIncluded = true )
public class Amount {
	
	// @ToString.Include
	private final BigDecimal value;

	private Amount(BigDecimal value) {
		Objects.requireNonNull(value);
		assert value.signum() != -1 : "value " + value + " can not be lesss than zero";
		assert value.scale() <= 2 : "The number of decimal places (" + value.scale() + ") cannot be greater than 2 digits." ;

		this.value = value.setScale(2, RoundingMode.HALF_UP);
	}

	public static Amount parse(String str) {
		Objects.requireNonNull(str, "string must not be null");
		assert !str.trim().isEmpty() : "string must be provided";
		BigDecimal value;
		try {
			value = new BigDecimal(str);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("string (" + str + ") dose not match a valid number format", e);
		}
		return new Amount(value);
	}

	public Amount multiply(Rate rate ) {
		Objects.requireNonNull(rate, "Rate can not be null");
		BigDecimal resultValue = this.value
										.multiply(rate.getValue())
										.setScale(2, RoundingMode.HALF_UP);
		return new Amount(resultValue);
	}

	public BigDecimal getValue() {
		return this.value;
	}
	public boolean isEqualTo(Amount amount) {
		Objects.requireNonNull(amount, "amount can not be null.");
		return this.value.compareTo(amount.value) == 0;
	}

	public boolean isGreaterThan(Amount amount) {
		Objects.requireNonNull(amount, "amount can not be null.");
		return this.value.compareTo(amount.value) > 0;
	}

	public boolean isGreaterThanOrEqualTo(Amount amount) {
		Objects.requireNonNull(amount, "amount can not be null.");
		return this.value.compareTo(amount.value) >= 0;
	}

	@Override
	public String toString() {
		return this.value.toString();
	}

	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}

		if(this == other) {
			return true;
		}
		if (!(other instanceof Amount)) {
			return false;
		}
		Amount otherAmount = (Amount) other;
		return this.isEqualTo(otherAmount);
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	}
	
	
}
