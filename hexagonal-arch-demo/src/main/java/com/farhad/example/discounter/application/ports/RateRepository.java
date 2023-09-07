package com.farhad.example.discounter.application.ports;

import java.util.ListIterator;

import com.farhad.example.discounter.application.BreakingPointWithRate;

public interface RateRepository {
	ListIterator<BreakingPointWithRate> getDiscountingBreakPointIterator();
}
