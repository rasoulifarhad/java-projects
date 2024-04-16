package com.farhad.example.design_principles02.elegant_objects_book.method_names.use_fakes.mocking;

public class App {

	public static void main(String[] args) {
		{
			Cash dollar = new Cash(new NYSE("secret"), 100);
			Cash euro = dollar.in("EUR");
			System.out.println(euro);
		}
	}
}
