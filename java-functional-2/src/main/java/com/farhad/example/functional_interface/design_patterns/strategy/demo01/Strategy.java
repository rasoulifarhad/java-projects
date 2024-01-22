package com.farhad.example.functional_interface.design_patterns.strategy.demo01;

public interface Strategy<X, Y> {

	public Y execute(X x);
}
