package com.farhad.example.functional_interface.design_patterns.strategy.demo03;

import lombok.Setter;

public class Context {

	@Setter
	private Strategy strategy;

	public void executeStrategy() {
		System.out.println(strategy.execute(10));
	}

}
