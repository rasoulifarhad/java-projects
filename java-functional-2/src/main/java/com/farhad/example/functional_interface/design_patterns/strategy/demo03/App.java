package com.farhad.example.functional_interface.design_patterns.strategy.demo03;

public class App {

	public static void main(String[] args) {
		
		Context context = new Context();
		context.setStrategy(Strategies.STRATEGYA);
		context.executeStrategy();

		context.setStrategy(Strategies.STRATEGYB);
		context.executeStrategy();

		context.setStrategy(i -> 1000 * i);
		context.executeStrategy();
	}
}
