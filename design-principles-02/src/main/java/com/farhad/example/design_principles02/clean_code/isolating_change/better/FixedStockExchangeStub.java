package com.farhad.example.design_principles02.clean_code.isolating_change.better;

import java.util.HashMap;
import java.util.Map;

public class FixedStockExchangeStub implements StockExchange {

	private Map<String, Double> stocks = new HashMap<>();

	@Override
	public Money currentValue(String symbol) {
		return stocks.containsKey(symbol) ?  new Money( stocks.get(symbol)) : new Money(0);
	}

	public void fix(String symbol, double value) {
		stocks.put(symbol, Double.valueOf(value));
	}

}
