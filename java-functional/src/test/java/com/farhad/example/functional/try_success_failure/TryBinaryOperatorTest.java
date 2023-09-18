package com.farhad.example.functional.try_success_failure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class TryBinaryOperatorTest {


	@Test
	public void testIntegerMinSuccess() {
		Optional<Try<Integer>> optResult = successNumbers().reduce(TryBinaryOperator.minBy(Comparator.naturalOrder()));
		assertTrue(optResult.isPresent());
		Try<Integer> result = optResult.get();
		assertTrue(result.isSuccess());
		assertThat(Integer.valueOf(2)).isEqualTo(result.get());
	}

	@Test
	public void testIntegerMaxSuccess() {
		Optional<Try<Integer>> optResult = successNumbers().reduce(TryBinaryOperator.maxBy(Comparator.naturalOrder()));
		assertTrue(optResult.isPresent());
		Try<Integer> result = optResult.get();
		assertTrue(result.isSuccess());
		assertThat(Integer.valueOf(195)).isEqualTo(result.get());
	}

	@Test
	public void testIntegerSumSuccess() {
		Optional<Try<Integer>> optResult = successNumbers().reduce(TryBinaryOperator.of(Integer::sum));
		assertTrue(optResult.isPresent());
		Try<Integer> result = optResult.get(); 
		assertTrue(result.isSuccess());
		assertThat(Integer.valueOf(283)).isEqualTo(result.get());
	}

	@Test
	public void testIntegerMinFailure() {
		Optional<Try<Integer>> optResult = mixedSuccessFailure().reduce(TryBinaryOperator.minBy(Comparator.naturalOrder()));
		assertTrue(optResult.isPresent());
		Try<Integer> result = optResult.get();
		assertTrue(result.isFailure());
	}

	@Test 
	public void testCustomComparatorSuccess() {
		Optional<Try<String>> optResult = strings().reduce(TryBinaryOperator.minBy(compareCharAt(4)));
		assertTrue(optResult.isPresent());
		Try<String> result = optResult.get();
		assertTrue(result.isSuccess());
		assertThat(result.get()).isEqualTo("foobar");
	}

	@Test 
	public void testCustomComparatorFailure() {
		Optional<Try<String>> optResult = strings().reduce(TryBinaryOperator.minBy(compareCharAt(5)));
		assertTrue(optResult.isPresent());
		Try<String> result = optResult.get();
		assertTrue(result.isFailure());
		assertTrue(result.failed().get() instanceof StringIndexOutOfBoundsException);
		
	}

	private Stream<Try<String>> strings() {
		List<String> strings = Arrays.asList("abcdefgh", "foobar", "dummy", "sample");
		return strings.stream().map(this::success);

	}

	private Stream<Try<Integer>> successNumbers() {
		List<Integer> ints = Arrays.asList(42, 5, 23, 16, 195, 2);
		return ints.stream().map(this::success);
	}

	private Stream<Try<Integer>> mixedSuccessFailure() {
		return Arrays.asList(success(1), success(2), failure(), success(3)).stream();
	}

	private Comparator<String> compareCharAt(int index) {
		return (a, b) -> Character.compare(a.charAt(index), b.charAt(index));
	}

	private <T> Try<T> success(T o) {
		return Try.apply(() -> o);
	}
	private Try<Integer> failure() {
		return Try.apply(() -> {throw new NumberFormatException("Number not valid.");});	
	}
}
