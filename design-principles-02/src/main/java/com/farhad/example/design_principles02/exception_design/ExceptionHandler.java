package com.farhad.example.design_principles02.exception_design;

import java.time.Instant;

public class ExceptionHandler {
	
	ErrorResult handel(BusinessException businessException) {
		return new ErrorResult(
			businessException.getMessage(), 
			businessException.getCode(), 
			Instant.now());
	}
}
