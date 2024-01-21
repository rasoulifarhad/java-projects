package com.farhad.example.generic.simple_list;

import java.math.BigDecimal;

public class App {

	public static void main(String[] args) {
		test_add_BigDecimal();
	}

	private static void test_add_BigDecimal() {
		SimpleList<BigDecimal> simpleList = new SimpleList<>();
		simpleList.add(BigDecimal.ONE);
		System.out.println("size: " + simpleList.size());

		simpleList.add(BigDecimal.ZERO);
		System.out.println("size: " + simpleList.size());

		simpleList.clear();
		System.out.println("size: " + simpleList.size());

	}
}