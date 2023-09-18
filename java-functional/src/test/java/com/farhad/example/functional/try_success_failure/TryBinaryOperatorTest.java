package com.farhad.example.functional.try_success_failure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TryBinaryOperatorTest {


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

	}

	@Test
	public void testForEachAgainstAFailure() {
		
	}


	@Test
	public void testMapAgainstASuccess() {

	}

	@Test
	public void testMapAgainstAFailure() {
		
	}

	@Test
	public void testFlatMapAgainstASuccess() {

	}

	@Test
	public void testFlatMapAgainstAFailure() {
		
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
