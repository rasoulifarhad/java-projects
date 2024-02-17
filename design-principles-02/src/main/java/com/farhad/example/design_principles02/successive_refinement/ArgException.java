package com.farhad.example.design_principles02.successive_refinement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArgException extends RuntimeException {

	private ErrorCode errorCode = ErrorCode.OK;
	private char errorArgumentId = '\0';
	private String errorParameter = null;

	public ArgException(ErrorCode errorCode, char errorArgumentId, String errorParameter) {
		this.errorCode = errorCode;
		this.errorArgumentId = errorArgumentId;
		this.errorParameter = errorParameter;
	}

	public ArgException(String message) {
		super(message);
	}

	public ArgException() {
	}

	public ArgException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public ArgException(ErrorCode errorCode, String errorParameter) {
		this.errorCode = errorCode;
		this.errorParameter = errorParameter;
	}

	public String errorMessage() {
		switch (errorCode) {
			case OK:
				return "TILT: Should not get here.";
			case UNEXPECTED_ARGUMENT:
				return String.format("Argument -%c unexpected.", errorArgumentId);
			case MISSING_STRING:
				return String.format("Could not find string parameter for -%c.",
						errorArgumentId);
			case INVALID_INTEGER:
				return String.format("Argument -%c expects an integer but was '%s'.",
						errorArgumentId, errorParameter);
			case MISSING_INTEGER:
				return String.format("Could not find integer parameter for -%c.",
						errorArgumentId);
			case INVALID_DOUBLE:
				return String.format("Argument -%c expects a double but was '%s'.",
						errorArgumentId, errorParameter);
			case MISSING_DOUBLE:
				return String.format("Could not find double parameter for -%c.",
						errorArgumentId);
			case INVALID_ARGUMENT_NAME:
				return String.format("'%c' is not a valid argument name.",
						errorArgumentId);
			case INVALID_ARGUMENT_FORMAT:
				return String.format("'%s' is not a valid argument format.",
						errorParameter);
		}
		return "";
	}

}
