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

		public int euroToUsd() {
			return this.toUsd("EUR");
		}
	}

	@RequiredArgsConstructor
	final class Fast implements Exchange {

		private final Exchange origin;
		@Override
		public int rate(String source, String target) {
			if (source.equals(target)) {
				return 1;
			} else {
				return this.origin.rate(source, target);
			}
		}

		public int toUsd(String source) {
			return this.origin.rate(source, "USD");
		}

	}
}
