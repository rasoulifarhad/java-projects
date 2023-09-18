package com.farhad.example.functional.try_success_failure;

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
