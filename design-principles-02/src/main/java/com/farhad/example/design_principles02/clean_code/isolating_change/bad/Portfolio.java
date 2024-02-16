package com.farhad.example.design_principles02.clean_code.isolating_change.bad;

import java.util.HashMap;
import java.util.Map;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Portfolio {

	private final TokyoStockExchange exchange;

	private Map<String, Integer> stocks = new HashMap<>();

	public void add(int shares, String symbol) {
		stocks.compute(symbol, (k, v) -> (v == null) ? shares : shares + v );
	}

	public double value() {
		return 0;
	}


}
