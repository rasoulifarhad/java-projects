package com.farhad.example.functional_interface.design_patterns.strategy.demo01;

import lombok.Setter;

public class Context {

	@Setter
	private Strategy<Integer, Integer> strategy;

	public void executeStrategy() {
		System.out.println(strategy.execute(10));
	}

}
