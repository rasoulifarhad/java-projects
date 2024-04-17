package com.farhad.example.design_principles02.elegant_objects_book.method_names.smart_interface;

import lombok.RequiredArgsConstructor;

public interface Exchange {

	int rate(String source, String target);

	@RequiredArgsConstructor
	final class Smart {
		private final Exchange origin;

		public int toUsd(String source) {
			return this.origin.rate(source, "USD");
		}
	}
}
