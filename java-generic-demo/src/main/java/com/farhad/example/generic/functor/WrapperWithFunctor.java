package com.farhad.example.generic.functor;

import java.util.function.Function;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WrapperWithFunctor<A> implements Functor<A> {

	private final A value;

	@Override
	public <B> WrapperWithFunctor<B> map(Function<A, B> f) {
		return new WrapperWithFunctor<B>(f.apply(value));
	}

	boolean valueEquals(A x) {
		return value.equals(x);
	}

}
