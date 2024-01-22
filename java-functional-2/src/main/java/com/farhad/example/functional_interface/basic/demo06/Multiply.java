package com.farhad.example.functional_interface.basic.demo06;

import java.util.function.BinaryOperator;

public interface Multiply {

	BinaryOperator<Integer> DIRECTMUL = (a, b) -> a * b;
	BinaryOperator<Integer> OTHERMUL = (a, b) -> otherMul(a, b);
	
	static Integer otherMul(Integer a, Integer b) {
		return a * b;
	}
}
