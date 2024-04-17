package com.farhad.example.design_principles02.elegant_objects_book.method_names.smart_interface;

public class App {

	public static void main(String[] args) {
		
		int rate = new Exchange.Smart(new NYSE("secret"))
				.toUsd("EUR");
	}
}
