package com.farhad.example.design_principles02.test_design.domain.model;

public class DomainException extends RuntimeException {
	
	public DomainException() {

	}

	public DomainException(String message) {
		super(message);
	}

	public DomainException(String message , Throwable throwable) {
		super(message, throwable);
	}

	public DomainException(Throwable throwable) {
	}

}
