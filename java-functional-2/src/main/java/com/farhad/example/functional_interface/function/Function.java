package com.farhad.example.functional_interface.function;

public interface Function {

	int apply(int arg);

	static Function compose(Function f1, Function f2) {
		return new Function() {

			@Override
			public int apply(int arg) {
				return f1.apply(f2.apply(arg));
			}
			
		};
	}
}
