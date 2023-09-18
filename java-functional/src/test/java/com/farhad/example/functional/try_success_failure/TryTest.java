package com.farhad.example.functional.try_success_failure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.Test;

public class TryTest {

	@Test
	public void testIsSuccess(){
		Try<Integer> result =  Try.apply(this::success);

		assertTrue(result.isSuccess(), "result must be a success");
	}

	@Test
	public void testIsFailure() {
		Try<Integer> result =  Try.apply(this::failure);

		assertTrue(result.isFailure(), "result must be a failure");
	}

	@Test
	public void testGetAgainstASuccess() {
		Try<Integer> result = Try.apply(this::success);

		int intResult = result.get();
		assertThat(intResult).isEqualTo(42);
	}

	@Test
	public void testGetAgainstAFailure() {
		Try<Integer> result = Try.apply(this::failure);

		assertThrows(GetOfFailureException.class, () -> result.get());
	}

	@Test
	public void testUncheckedGetAgainstASuccess() throws Exception {
		Try<Integer> result = Try.apply(this::success);
		int intResult = result.checkedGet();

		assertThat(intResult).isEqualTo(42);
	}

	@Test
	public void testUncheckedGetAgainstAFailure() throws Exception {
		Try<Integer> result = Try.apply(this::failure);

		assertThrows(NumberFormatException.class, () -> result.checkedGet());
	}

	@Test
	public void testForEachAgainstASuccess() {
		Try<Integer> result = Try.apply(this::success);
		result.forEach(i -> assertThat(i).isEqualTo(Integer.valueOf(42)));
	}

	@Test
	public void testForEachAgainstAFailure() {
		Try<Integer> result = Try.apply(this::failure);
		AtomicBoolean  isForeachExecuted = new AtomicBoolean(false);
		result.forEach(i -> isForeachExecuted.getAndSet(true));
		assertFalse(isForeachExecuted.get());
		assertThrows(GetOfFailureException.class, () -> result.get());
	}


	@Test
	public void testMapAgainstASuccess() {
		Try<Integer> result = Try.apply(this::success);
		Try<String> mappedResult = result.map(i -> i.toString() + ", Hello World!");
		assertThat(mappedResult).isEqualTo(new Try.Success<String>("42, Hello World!"));
	}

	@Test
	public void testMapAgainstAFailure() {
		Try<Integer> result = Try.apply(this::failure);
		AtomicBoolean  isForeachExecuted = new AtomicBoolean(false);
		result.map(i -> isForeachExecuted.getAndSet(true));
		assertFalse(isForeachExecuted.get());
		assertThrows(GetOfFailureException.class, () -> result.get());
	}

	@Test
	public void testFlatMapAgainstASuccess() {
		Try<Integer> result = Try.apply(this::success);
		Try<String> flatMappedResult = result.flatMap(i -> Try.apply(() -> i + ", " + anotherSuccess()));
		assertThat(flatMappedResult).isEqualTo(new Try.Success<String>("42, Hello World!"));
	}

	@Test
	public void testFlatMapAgainstAFailure() {
		Try<Integer> result = Try.apply(this::failure);
		AtomicBoolean  isForeachExecuted = new AtomicBoolean(false);
		result.flatMap(i -> Try.apply(() -> isForeachExecuted.getAndSet(true)));
		assertFalse(isForeachExecuted.get());
		assertThrows(GetOfFailureException.class, () -> result.get());
	}

	@Test
	public void testFilterAgainstASuccess() {

	}

	@Test
	public void testFilterAgainstAFailure() {
		
	}

	@Test
	public void testNonMatchingFilter() {

	}

	@Test
	public void testRecoverAgainstASuccess() {

	}

	@Test
	public void testRecoverAgainstAFailure() {
		
	}

		@Test
	public void testRecoverWithAgainstASuccess() {

	}

	@Test
	public void testRecoverWithAgainstAFailure() {
		
	}

	@Test
	public void testFailedAgainstASuccess() {

	}

	@Test
	public void testFailedAgainstAFailure() {
		
	}

	@Test
	public void testToOptionalAgainstASuccess() {

	}

	@Test
	public void testToOptionalAgainstAFailure() {
		
	}

		@Test
	public void testGetOrElseAgainstASuccess() {

	}

	@Test
	public void testGetOrElseAgainstAFailure() {
		
	}


	@Test
	public void testOrElseAgainstASuccess() {

	}

	@Test
	public void testOrElseAgainstAFailure() {
		
	}

		@Test
	public void testTransformAgainstASuccess() {

	}

	@Test
	public void testTransformAgainstAFailure() {
		
	}

	private int success() {
        return 42;
    }

    private String anotherSuccess() {
        return "Hello World!";
    }

    private int failure() throws NumberFormatException {
        throw new NumberFormatException("Number not valid");
    }

}
