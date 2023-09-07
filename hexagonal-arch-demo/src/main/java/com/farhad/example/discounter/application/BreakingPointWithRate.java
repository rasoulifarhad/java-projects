package com.farhad.example.discounter.application;

import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BreakingPointWithRate {
	@EqualsAndHashCode.Include
	private final Amount breakPoint;
	private final Rate rate;

	public BreakingPointWithRate(Amount breakPoint, Rate rate) {
		Objects.requireNonNull(breakPoint, "BreakPoint can not be null");
		Objects.requireNonNull(rate, "rate can not be null");
		this.breakPoint = breakPoint;
		this.rate = rate;
	}
}
