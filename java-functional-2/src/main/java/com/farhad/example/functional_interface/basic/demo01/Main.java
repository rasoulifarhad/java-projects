package com.farhad.example.functional_interface.basic.demo01;

public class Main {

	public static void main(String[] args) {
		IFunction mul = FunctionFactory.getFunctionMul();
		System.out.println(mul.doFunction(2, 3));
	}
}
