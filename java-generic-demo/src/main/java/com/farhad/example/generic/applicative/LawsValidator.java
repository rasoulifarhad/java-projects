package com.farhad.example.generic.applicative;

import java.util.function.Function;
import java.util.function.Supplier;

public class LawsValidator {

	public static void main(String[] args) {
		
		int x = 2;
		Function<Integer, String> f = Object::toString;
		Function<String, Long> g = Long::valueOf;
		
		// identity
		ReferentialApplicative<Integer> identity = ReferentialApplicative.pure(x)
				.apply(ReferentialApplicative.pure(Function.identity()));
		assert identity.valueEquals(ReferentialApplicative.pure(x));

		// Homomorphism
		ReferentialApplicative<String> leftSide = ReferentialApplicative.pure(x).apply(ReferentialApplicative.pure(f));
		ReferentialApplicative<String> rightSide = ReferentialApplicative.pure(f.apply(x));
		assert leftSide.valueEquals(rightSide);

		// Interchange
		// As far as I can tell it is as close, to original meaning of this Law, as possible in Java
		ReferentialApplicative<String> interchangeLeftSide = ReferentialApplicative.pure(x)
				.apply(ReferentialApplicative.pure(f));
		Supplier<Integer> supplier = () -> x;

		Function<Supplier<Integer>, String> temp = i -> f.apply(i.get());
		ReferentialApplicative<String> interchangeRightSide = ReferentialApplicative.pure(supplier)
				.apply(ReferentialApplicative.pure(temp));
		assert interchangeLeftSide.equals(interchangeRightSide);

		// Composition
		// As far as I can tell it should be in line with what is expected from this Law
		ReferentialApplicative<Long> compositionLeftSide = ReferentialApplicative.pure(x)
				.apply(ReferentialApplicative.pure(f)).apply(ReferentialApplicative.pure(g));
		ReferentialApplicative<Long> compositionRightSide = ReferentialApplicative.pure(x)
				.apply(ReferentialApplicative.pure(f.andThen(g)));
		assert compositionLeftSide.valueEquals(compositionRightSide);
	}
}
