package com.farhad.example.design_principles02.exception_design;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PaymentException implements ExceptionBase {
	PAYMENT_CAN_NOT_BE_VERIFIED("payment can not be verified", 200);

	private final String message;
	private final Integer code;
}
