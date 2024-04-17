package com.farhad.example.design_principles02.elegant_objects_book.method_names.smart_interface;

public class NYSE implements Exchange {


	private String password;

	public NYSE(String password) {
		this.password = password;
	}

	@Override
	public int rate(String string, String currency) {
		return 2;
	}

}
