package com.farhad.example.design_principles02.elegant_objects_book.method_names.be_immutable.mutable;

import lombok.ToString;

@ToString
public class Cash {

	private int dollars;


	public Cash(int dollars) {
		this.dollars = dollars;
	}

	public void mul(int factor) {
		dollars *= factor;
	}

	
}
	