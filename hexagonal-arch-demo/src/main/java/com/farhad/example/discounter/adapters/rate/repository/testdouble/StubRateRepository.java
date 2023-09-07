package com.farhad.example.discounter.adapters.rate.repository.testdouble;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.farhad.example.discounter.application.Amount;
import com.farhad.example.discounter.application.BreakingPointWithRate;
import com.farhad.example.discounter.application.Rate;
import com.farhad.example.discounter.application.ports.RateRepository;

public class StubRateRepository implements RateRepository {

	private List<BreakingPointWithRate> rateTable;

	public StubRateRepository() {
		this.rateTable = new ArrayList<>();
		BreakingPointWithRate breakPoint__0__rate__0 = new BreakingPointWithRate(Amount.parse("0"), Rate.parse("0"));
		BreakingPointWithRate breakPoint__500__rate__0_03 = new BreakingPointWithRate(Amount.parse("500"), Rate.parse("0.03"));
		BreakingPointWithRate breakPoint__5000__rate__0_05 = new BreakingPointWithRate(Amount.parse("5000"), Rate.parse("0.05"));
		this.rateTable.add(breakPoint__0__rate__0);
		this.rateTable.add(breakPoint__500__rate__0_03);
		this.rateTable.add(breakPoint__5000__rate__0_05);
	}

	@Override
	public ListIterator<BreakingPointWithRate> getDiscountingBreakPointIterator() {
		return this.rateTable.listIterator(rateTable.size());
	}
	
}
