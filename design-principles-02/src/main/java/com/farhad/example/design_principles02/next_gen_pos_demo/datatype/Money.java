package com.farhad.example.design_principles02.next_gen_pos_demo.datatype;

import java.math.BigDecimal;
import java.util.Currency;

import lombok.Getter;
import lombok.Value;

@Value
public class Money implements Comparable<Money> {

	private static Currency DEFAULT_CURRENCY = Currency.getInstance("USD");
	@Getter
	private BigDecimal value;

	@Getter
	private Currency currency;

	private Money() {
		this(BigDecimal.ZERO, DEFAULT_CURRENCY);
	}

	private Money(BigDecimal value) {
		this(value, DEFAULT_CURRENCY);
	}

	private Money(BigDecimal value, Currency currency) {
		this.value = value;
		this.currency = currency;
	}




	public static Money of(String stringValue) {
		return of(new BigDecimal(stringValue), DEFAULT_CURRENCY);
	}

	public static Money of(double value) {
		return of(value, DEFAULT_CURRENCY);
	}

	public static Money of(double value, Currency currency) {
		return new Money(new BigDecimal(Double.toString(value)), currency);
	}

	public static Money of(BigDecimal value, Currency currency) {
		return new Money(value, currency);
	}

	public static Money of(BigDecimal value) {
		return new Money(value, DEFAULT_CURRENCY);
	}

	public static Money of(int value, Currency currency) {
		return new Money(new BigDecimal(Integer.toString(value)), currency);
	}

	public static Money of(int value) {
		return new Money(new BigDecimal(Integer.toString(value)), DEFAULT_CURRENCY);
	}


	public Money add(Money money) {
		return new Money(value.add(money.getValue()));
	}
	
	public Money times(int factor) {
		return new Money(value.multiply(BigDecimal.valueOf(factor)));
	}

	public Money minus(Money money) {
		return new Money(value.min(money.getValue()));
	}

	@Override
	public int compareTo(Money o) {
		checkCurrenciesMatch(o);
		return this.value.compareTo(o.value);
	}

	private void checkCurrenciesMatch(Money o) {
		if (!this.currency.equals(o.getCurrency())) {
			throw new MismatchedCurrencyException(
					o.getCurrency() + " doesn't match the expected currency : " + currency);
		}
	}
	
	public String toString() {
		return value.toPlainString() + " " + currency.toString();
	}

}
