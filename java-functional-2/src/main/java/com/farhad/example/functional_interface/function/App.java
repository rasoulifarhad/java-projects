package com.farhad.example.functional_interface.function;

public class App {

	public static void main(String[] args) {
		
		final Function tripleFunction = new Function() {

			@Override
			public int apply(int arg) {
				return 3 * arg;
			}
			
		};

		final int result = tripleFunction.apply(2);
		System.out.println(result);

		final Function squareFunction = new Function() {

			@Override
			public int apply(int arg) {
				return arg * arg;
			}
			
		};

		final int squareResult = squareFunction.apply(2);
		System.out.println(squareResult);

		Function intermediaryComposedFunction = Function.compose(tripleFunction, squareFunction);
		final int composeResult = intermediaryComposedFunction.apply(2);
		System.out.println(composeResult);
	}
}
