package com.farhad.example.design_principles02.clean_code.isolating_change.better;

public interface StockExchange {

	Money currentValue(String symbol);
}
