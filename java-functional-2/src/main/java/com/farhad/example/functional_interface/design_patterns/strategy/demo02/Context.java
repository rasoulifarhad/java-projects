package com.farhad.example.functional_interface.design_patterns.strategy.demo02;

import lombok.Setter;

public class Context {

	@Setter
	private Strategies strategy;

	public void executeStrategy() {
		System.out.println(strategy.execute(10));
	}
}
