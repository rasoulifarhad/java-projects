package com.farhad.example.generic.functor;

import java.util.function.Function;

public class App {

	public static void main(String[] args) {
		
		int x = 2;
		Function<Integer, String> f = Object::toString;

		Wrapper<Integer> wrapper = new Wrapper<Integer>(x);
		String mappedValue = f.apply(wrapper.getValue());
		Wrapper<String> mappedWrapper = new Wrapper<String>(mappedValue);
		// Wrapper<String> mappedWrapper = new Wrapper<String>(f.apply(x));

		WrapperWithFunctor<Integer> wrapperWithFunctor = new WrapperWithFunctor<Integer>(x);
		WrapperWithFunctor<String> mappedWrapperWithFunctor = wrapperWithFunctor.map(f);

		assert mappedWrapperWithFunctor.valueEquals(mappedWrapper.getValue());

	}
}
