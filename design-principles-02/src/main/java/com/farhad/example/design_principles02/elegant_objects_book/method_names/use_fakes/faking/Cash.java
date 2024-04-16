package com.farhad.example.design_principles02.elegant_objects_book.method_names.use_fakes.faking;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Cash {

	private final Exchange exchange;
	private final int cents;

	public Cash in(String currency) {
		return new Cash(
				this.exchange,
				this.cents * this.exchange.rate("USD", currency));
	}

	@Override
	public String toString() {
		return "¢" + cents + "";
	}
	
	
}
