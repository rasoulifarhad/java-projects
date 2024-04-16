package com.farhad.example.design_principles02.elegant_objects_book.method_names.be_immutable.mutable;

import lombok.ToString;

@ToString
public class Cash {

	private int dollars;
	private int cents;

	public Cash(int dollars) {
		this(dollars, 0);
	}

	

	public Cash(int dollars, int cents) {
		this.dollars = dollars;
		this.cents = cents;
	}



	public void mul(int factor) {
		this.dollars *= factor;
		if (cents > 0/* something is wrong */) {
			throw new RuntimeException("oops...");
		}
		
		this.cents *= factor;
	}

	public void failureAtomicity_mul(int factor) {
		int before = this.dollars;
		this.dollars *= factor;
		if (cents > 0/* something is wrong */) {
			this.dollars = before;
			throw new RuntimeException("oops...");
		}

		this.cents *= factor;
	}	

	
}
	