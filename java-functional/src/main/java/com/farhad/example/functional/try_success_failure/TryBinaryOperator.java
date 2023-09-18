package com.farhad.example.functional.try_success_failure;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.BinaryOperator;

public interface TryBinaryOperator<T>  extends BinaryOperator<Try<T>> {
	
	public static <T>  TryBinaryOperator<T> of(BinaryOperator<T> binaryOperator) {
		Objects.requireNonNull(binaryOperator);
		return (a, b) -> a.flatMap(x -> b.map(y -> binaryOperator.apply(x, y)));
	}

	public static <T> TryBinaryOperator<T> minBy(Comparator<? super T>  comparator) {
		return TryBinaryOperator.of(BinaryOperator.minBy(comparator));
	}

	public static <T> TryBinaryOperator<T> maxBy(Comparator<? super T>  comparator) {
		return TryBinaryOperator.of(BinaryOperator.maxBy(comparator));
	}

}
 