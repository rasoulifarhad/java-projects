package com.farhad.example.design_principles02.exception_design;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ErrorResult {
	
	private final String message;
	private final Integer code;
	private final Instant date;
}
