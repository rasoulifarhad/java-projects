package com.farhad.example.design_principles02.clean_code.isolating_change.better;

import java.util.HashMap;
import java.util.Map;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Portfolio {

	private final StockExchange stockExchange;
	private Map<String, Integer> stocks = new HashMap<>();

	public void add(int shares, String symbol) {
		stocks.compute(symbol, (k, v) -> (v == null) ? shares : shares + v );
	}

	public Money value() {

		return new Money(stocks.entrySet().stream()
			.map(entrySet -> stockExchange.currentValue(entrySet.getKey()).factor(entrySet.getValue()))
			.mapToDouble(m -> m.getValue())
			.sum());
	}
}
