package com.farhad.example.combinator;

import java.util.Optional;

import lombok.Value;

public class ValidatorDemo {
	
	@Value
	static class User {
		final String name;
		final int age;
		final String email;
	}

	interface ValidationResult {
		static ValidationResult valid() {
			return ValidationSupport.valid();
		}
		static ValidationResult inValid(String reason) {
			return new Invalid(reason);
		}

		boolean isValid();
		Optional<String> getReason();
	}
	
	@Value
	private final static class Invalid implements ValidationResult {

		private final String reason;

		@Override
		public boolean isValid() {
			return false;
		}

		@Override
		public Optional<String> getReason() {
			return Optional.of(reason);
		}
		
	}

	private final static class ValidationSupport {
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

	private static <T> T todo() {
		throw new UnsupportedOperationException();
	}
}
