package com.farhad.example.functional.try_success_failure;

public class GetOfFailureException extends RuntimeException {
	private static final String message = "get of a failure  object";

	public GetOfFailureException(Throwable cause) {
		super(cause);
	}
}
