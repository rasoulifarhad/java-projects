package com.farhad.example.functional_interface.design_patterns.strategy.demo01;

public class StrategyB implements Strategy<Integer, Integer> {

	@Override
	public Integer execute(Integer x) {
		return x * 100;
	}

}
