package com.farhad.example.functional_interface.basic.demo01;

public class FunctionFactory {

	public static IFunction getFunctionAdd() {
		return (a, b) -> a + b;
	}

	public static IFunction getFunctionMul() {
		return (a, b) -> a * b;
	}

}
