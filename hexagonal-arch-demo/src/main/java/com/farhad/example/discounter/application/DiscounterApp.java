package com.farhad.example.discounter.application;

import java.util.ListIterator;
import java.util.Objects;

import com.farhad.example.discounter.application.ports.Discounter;
import com.farhad.example.discounter.application.ports.RateRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DiscounterApp implements Discounter {

	private static final Rate CONSTANT_RATE_FOR_ANY_AMOUNT = Rate.parse("0.08");

	private final RateRepository rateRepository;

	@Override
	public Amount calculateDiscount(Amount amount) {
		Objects.requireNonNull(amount, "Amount can not be null");
		Rate rate = findRateOfAmount(amount);
		return amount.multiply(rate);
	}

	private Rate findRateOfAmount(Amount amount) {
		if (this.rateRepository == null) {
			return CONSTANT_RATE_FOR_ANY_AMOUNT;
		}
		ListIterator<BreakingPointWithRate> breakingPointWithRateIterator =  this.rateRepository.getDiscountingBreakPointIterator();
		while (breakingPointWithRateIterator.hasPrevious()) {
			BreakingPointWithRate breakingPointWithRate = breakingPointWithRateIterator.previous();
			if (amount.isGreaterThanOrEqualTo(breakingPointWithRate.getBreakPoint())) {
				return breakingPointWithRate.getRate();
			}
		}
		throw new RuntimeException("No rate found for the amount: " + amount);
	}
	
}
