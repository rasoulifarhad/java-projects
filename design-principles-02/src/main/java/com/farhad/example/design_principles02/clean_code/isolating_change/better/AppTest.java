package com.farhad.example.design_principles02.clean_code.isolating_change.better;

public class AppTest {

	public static void main(String[] args) {
		
		FixedStockExchangeStub stockExchange = new FixedStockExchangeStub();
		stockExchange.fix("MSFT", 100);

		Portfolio portfolio = new Portfolio(stockExchange);
	
		portfolio.add(5, "MSFT");
		System.out.println(portfolio.value());
	}
}
