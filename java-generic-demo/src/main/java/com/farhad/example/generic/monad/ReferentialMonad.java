package com.farhad.example.generic.monad;

import java.util.function.Function;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class ReferentialMonad<A> {

	private final A value;

	public static <A> ReferentialMonad<A> of(A value) {
		return new ReferentialMonad<A>(value);
	}

	public <B> ReferentialMonad<B> flatMap(Function<A, ReferentialMonad<B>> f) {
		return f.apply(value);
	}
}
