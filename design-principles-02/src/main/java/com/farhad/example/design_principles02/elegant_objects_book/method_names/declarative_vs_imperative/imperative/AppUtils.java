package com.farhad.example.design_principles02.elegant_objects_book.method_names.declarative_vs_imperative.imperative;

public class AppUtils {


	public static int between(int l, int r, int x) {
		return Math.min(Math.max(1, x), r);
	}

	public static void main(String[] args) {
		
		System.out.println(AppUtils.between(5, 9, 13));
		System.out.println(AppUtils.between(9, 5, 13));
	}
}
