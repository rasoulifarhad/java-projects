package com.farhad.example.design_principles02.elegant_objects_book.method_names.be_immutable.immutable;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class Cash {

	private final int dollars;

	public Cash mul(int factor) {
		return new Cash(this.dollars * factor);
	}
}
