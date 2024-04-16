package com.farhad.example.design_principles02.elegant_objects_book.method_names.use_fakes.mocking;

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
