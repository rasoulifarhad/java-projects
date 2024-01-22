package com.farhad.example.functional_interface.basic.demo04;

import java.util.function.Function;

public class App {
	public static void main(String[] args) {
		
		System.out.println(Multiply.DIRECTMUL.apply(2, 3));
		System.out.println(Multiply.OTHERMUL.apply(2, 3));

		Function<Integer, Integer> plus1 = i -> i + 1;
		System.out.println(Multiply.DIRECTMUL.andThen(plus1).apply(2, 3));
		
	}
}
