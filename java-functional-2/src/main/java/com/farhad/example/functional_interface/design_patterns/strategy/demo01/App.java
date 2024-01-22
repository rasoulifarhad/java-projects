package com.farhad.example.functional_interface.design_patterns.strategy.demo01;

public class App {

	public static void main(String[] args) {
		Context context = new Context();
		context.setStrategy(new StrategyA());
		context.executeStrategy();
		context.setStrategy(new StrategyB());
		context.executeStrategy();
	}
}
