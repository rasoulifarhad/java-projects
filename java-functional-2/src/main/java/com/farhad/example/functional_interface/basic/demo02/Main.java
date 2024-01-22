package com.farhad.example.functional_interface.basic.demo02;

import java.util.function.BinaryOperator;

public class Main {

	public static void main(String[] args) {
		BinaryOperator<Integer> mul = FunctionFactory.getFunctionMul();
		System.out.println(mul.apply(2, 3));
	}
}
