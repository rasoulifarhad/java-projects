package com.farhad.example.design_principles02.test_design.domain.application;

public class BusinessException extends RuntimeException {
	
	public BusinessException() {

	}

	public BusinessException(String message) {
		super(message);
	}
}
