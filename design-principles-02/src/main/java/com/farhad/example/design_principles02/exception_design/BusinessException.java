package com.farhad.example.design_principles02.exception_design;

import lombok.Getter;

public class BusinessException extends RuntimeException {

	@Getter
	private Integer code;

	public BusinessException(String message) {
		super(message);
		
	}

	public BusinessException(ExceptionBase exceptionBase) {
		this(exceptionBase.getMessage());
		this.code = exceptionBase.getCode();
	}

	
}
