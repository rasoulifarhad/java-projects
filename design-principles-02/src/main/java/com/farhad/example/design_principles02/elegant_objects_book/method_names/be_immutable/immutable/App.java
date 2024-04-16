package com.farhad.example.design_principles02.elegant_objects_book.method_names.be_immutable.immutable;

public class App {

	public static void main(String[] args) {
		Cash five = new Cash(5);
		Cash fifty = five.mul(10);
		System.out.println(fifty);

		Cash price = new Cash(29, 95);
		System.out.println(price);
	}
}
