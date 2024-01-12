package com.farhad.example.generic.monad;

import java.util.function.Function;

public class App {

	public static void main(String[] args) {
		
		int x = 2;

		Function<Integer, Wrapper<String>> toString = i -> new Wrapper<>(i.toString());
		Function<String, Wrapper<Integer>> hashcode = s -> new Wrapper<>(s.hashCode());
		Wrapper<Integer> wrapper = new Wrapper<Integer>(x);
		Wrapper<String> stringifyWrapper = toString.apply(wrapper.getValue());
		Wrapper<Integer> hashcodeWrapper = hashcode.apply(stringifyWrapper.getValue());


		Function<Integer, WrapperMonad<String>> toStringM = i -> WrapperMonad.of(i.toString());
		Function<String, WrapperMonad<Integer>> hashcodeM = s -> WrapperMonad.of(s.hashCode());

		WrapperMonad<Integer> hashCodedWrapperMonadic = WrapperMonad.of(x).flatMap(toStringM).flatMap(hashcodeM);

		assert hashCodedWrapperMonadic.valueEquals(hashcodeWrapper.getValue());
		System.out.println("Values inside wrappers are equal");

	}
}
