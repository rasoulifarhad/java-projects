package com.farhad.example.functional_interface.design_patterns.strategy.demo03;

public interface Strategies {

	Strategy STRATEGYA = i -> 10 * i;
	Strategy STRATEGYB = i -> 100 * i;
}
