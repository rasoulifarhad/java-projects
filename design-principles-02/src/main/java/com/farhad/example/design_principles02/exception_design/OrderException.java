package com.farhad.example.design_principles02.exception_design;

import static java.util.Objects.requireNonNull;

public enum OrderException implements ExceptionBase {
	ORDER_NOT_FOUNT("Order not found", 101),
	ORDER_ID_IS_NULL("Order id mus not be null", 102),
	ORDER_STATE_INVALID("state invalid", 103);

	private final String message;
	private final Integer code;

	OrderException(String message, Integer code) {
		this.message = requireNonNull(message);
		this.code = requireNonNull(code);
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public Integer getCode() {
		return code;
	}
	
}
