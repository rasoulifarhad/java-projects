package com.farhad.example.generic.applicative;

import java.util.Optional;
import java.util.function.Function;

public final class OptionalApplicative<A> implements Functor<A> {

	private final Optional<A> value;

	
	private OptionalApplicative(A value) {
		this.value = Optional.of(value);
	}

	

	private OptionalApplicative() {
		value = Optional.empty();
	}

	static <A> OptionalApplicative<A> pure(A value) {
		return new OptionalApplicative<A>(value);
	}

	<B> OptionalApplicative<B> apply(OptionalApplicative<Function<A, B>> f) {
		Optional<B> apply = f.value.flatMap(value::map);
		return apply.map(OptionalApplicative::new).orElseGet(OptionalApplicative::new);
	}

	@Override
	public <B> Functor<B> map(Function<A, B> f) {
		return apply(pure(f));
	}

	public boolean valueEquals(Optional<A> a) {
		return value.equals(a);
	}

}
