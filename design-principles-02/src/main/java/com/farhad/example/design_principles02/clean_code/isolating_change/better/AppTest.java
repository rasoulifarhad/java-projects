package com.farhad.example.design_principles02.clean_code.isolating_change.better;

public class AppTest {

	public static void main(String[] args) {
		
		FixedStockExchangeSup stockExchange = new FixedStockExchangeSup();
		stockExchange.fix("MSFT", 100);

		Portfolio portfolio = new Portfolio(stockExchange);
	
		portfolio.add(5, "MSFT");
		System.out.println(portfolio.value());
	}
}
