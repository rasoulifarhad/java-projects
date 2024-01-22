package com.farhad.example.functional_interface.basic.demo05;

import java.util.function.BinaryOperator;

public enum Multiply implements BinaryOperator<Integer> {

	DIRECTMUL((a, b) -> a * b ),
	OTHERMUL((a, b) -> otherMul(a, b));

	private BinaryOperator<Integer> multiplier;

	private Multiply(BinaryOperator<Integer> multiplier) {
		this.multiplier = multiplier;
	}

	private static Integer otherMul(Integer a, Integer b) {
		return a * b;
	}

	@Override
	public Integer apply(Integer a, Integer b) {
		return this.multiplier.apply(a, b);
	}
}