package com.farhad.example.generic.monad;

import java.util.function.Function;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public final class WrapperMonad<A> {

	private final A value;

	public static <A> WrapperMonad<A> of(A value) {
		return new WrapperMonad<A>(value);
	}

	public <B> WrapperMonad<B> flatMap(Function<A, WrapperMonad<B>> f) {
		return f.apply(value);
	}

	public boolean valueEquals(A x) {
		return value.equals(x);
	}	
}
