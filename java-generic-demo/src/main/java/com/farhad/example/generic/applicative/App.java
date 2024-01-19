package com.farhad.example.generic.applicative;

import java.util.Optional;
import java.util.function.Function;

public class App {

	public static void main(String[] args) {
		int x = 2;
		Function<Integer, String> f = Object::toString;

		Optional<Function<Integer, String>> optionalFunction = Optional.of(f);
		Optional<Integer> optional = Optional.of(x);

		Optional<String> result = optional.flatMap(v -> optionalFunction.map(of -> of.apply(v)));

		System.out.println(result.get());

		OptionalApplicative<Integer> applicative = OptionalApplicative.pure(x);
		OptionalApplicative<Function<Integer, String>> pure = OptionalApplicative.pure(f);

		OptionalApplicative<String> applicativeResult = applicative.apply(pure);

		assert applicativeResult.equals(result);


	}
}