package com.farhad.example.design_principles02.elegant_objects_book.method_names.use_fakes.faking;

public interface Exchange {

	int rate(String origin, String target);

	final class Fake implements Exchange {

		@Override
		public int rate(String origin, String target) {
			return 3;
		}

	}
}
