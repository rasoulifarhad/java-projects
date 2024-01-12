package com.farhad.example.generic.functor;

import java.util.function.Function;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ReferentialFunctor<A> implements Functor<A> {

	private final A value;
	
	@Override
	public <B> ReferentialFunctor<B> map(Function<A, B> f) {
		return new ReferentialFunctor<B>(f.apply(value));
	}

	boolean valueEquals(A x) {
		return value.equals(x);
	}

}
