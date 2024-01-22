package com.farhad.example.functional_interface.basic.demo02;

import java.util.function.BinaryOperator;

public class FunctionFactory {

	public static BinaryOperator<Integer> getFunctionAdd() {
		return (a, b) -> a + b;
	}
	
	public static BinaryOperator<Integer> getFunctionMul() {
		return (a, b) -> a * b;
	}
}
