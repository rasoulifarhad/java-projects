package com.farhad.example.design_principles02.elegant_objects_book.method_names.be_immutable.immutable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Cash {

	private final int dollars;
	private final int cents;

	
	public Cash(int dollars) {
		this(dollars, 0);
	}


	public Cash mul(int factor) {
		// if (cents > 0) {
		// 	throw new RuntimeException("oops...");
		// }
		return new Cash(this.dollars * factor, this.cents * factor);
	}
	
	@Override
	public String toString() {
		return String.format("$%d.%d", dollars, cents);
	}

}
