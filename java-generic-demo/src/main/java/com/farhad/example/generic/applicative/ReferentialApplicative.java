package com.farhad.example.generic.applicative;

import java.util.function.Function;

public final class ReferentialApplicative<A> implements Functor<A> {

	private final A value;

	

	public ReferentialApplicative(A value) {
		this.value = value;
	}

	static <A> ReferentialApplicative<A> pure(A value) {
		return new ReferentialApplicative<A>(value);
	}

	<B> ReferentialApplicative<B> apply(ReferentialApplicative<Function<A, B>> f) {
		B apply = f.value.apply(value);
		return pure(apply);
	}

	@Override
	public <B> Functor<B> map(Function<A, B> f) {
		return apply(pure(f));
	}

	public boolean valueEquals(ReferentialApplicative<A> compare) {
		return this.value.equals(compare.value);
	}

}
