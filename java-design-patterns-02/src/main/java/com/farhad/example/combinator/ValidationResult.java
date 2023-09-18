package com.farhad.example.combinator;

import java.util.Optional;

import lombok.Value;


public interface ValidationResult {
	static ValidationResult valid() {
		return ValidationSupport.valid();
	}
	static ValidationResult inValid(String reason) {
		return new Invalid(reason);
	}

	boolean isValid();

	Optional<String> getReason();

	@Value
	public final static class Invalid implements ValidationResult {

		private String reason;

		@Override
		public boolean isValid() {
			return false;
		}

		@Override
		public Optional<String> getReason() {
			return Optional.of(reason);
		}
		
	}

	public final static class ValidationSupport {
		private static final ValidationResult valid = new ValidationResult() {

			@Override
			public boolean isValid() {
				return true;
			}

			@Override
			public Optional<String> getReason() {
				return Optional.empty();
			}
			
		};

		static ValidationResult valid() {
			return valid;
		}
	}

	public static <T> T todo() {
		throw new UnsupportedOperationException();
	}

}


