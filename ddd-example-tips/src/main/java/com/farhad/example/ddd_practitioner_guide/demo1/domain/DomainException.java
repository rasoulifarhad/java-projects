package com.farhad.example.ddd_practitioner_guide.demo1.domain;

public class DomainException extends RuntimeException {
	
	public DomainException(final String message) {
		super(message);
	}
}
