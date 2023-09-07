package com.farhad.example.discounter.adapters.rate.repository.testdouble;

import java.util.ListIterator;

import com.farhad.example.discounter.application.BreakingPointWithRate;
import com.farhad.example.discounter.application.ports.RateRepository;

public class StubRateRepository implements RateRepository {

	@Override
	public ListIterator<BreakingPointWithRate> getDiscountingBreakPointIterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getDiscountingBreakPointIterator'");
	}
	
}
