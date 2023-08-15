package com.farhad.example.functional.patterns.combinator.ValidationWithCombinators;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.EqualsAndHashCode;

// See https://gtrefs.github.io/code/combinator-pattern/
//
// A user is valid if and only if a given set of rules are satisfied. 
// A rule describes the properties a user must have. 
// Different rules can be combined to more complex ones. 
// Applying a rule yields a validation result which describes the outcome. 

public class ValidationResultReasoning {

	static class User {

		public final String name;
		public final int age;
		public final String email;

		
		public User(String name, int age, String email) {
			Objects.requireNonNull(name);
			Objects.requireNonNull(email);
			this.name = name;
			this.age = age;
			this.email = email;
		}
	}

	interface UserValidation extends Function<User, ValidationResult> {
		static UserValidation nameIsNotEmpty() {
			return  holds(user -> !user.name.trim().isEmpty(), "Name is empty"); 
		}

		static UserValidation emailContainsAtsign() {
			return  holds(user -> user.email.contains("@"), "Missing @"); 
		}

		static UserValidation holds(Predicate<User> p, String message) {
			return user -> p.test(user) ? ValidationResult.valid() : ValidationResult.invalid(message);  
		}
		default UserValidation and(UserValidation other) {
			return user -> {
				ValidationResult result = this.apply(user);
				return result.isValid() ? other.apply(user) : result; 
			};
		}
	}
	public interface ValidationResult {

		static ValidationResult valid() {
			return new Valid();
		}

		static ValidationResult invalid(String reason) {
			return new InValid(reason);
		}

		boolean isValid();
		Optional<String> getReason();
	}


	@EqualsAndHashCode
	private static final class Valid implements ValidationResult {

	
		@Override
		public boolean isValid() {
			return true;
		}

		@Override
		public Optional<String> getReason() {
			return Optional.empty();
		}

	}

	@EqualsAndHashCode
	private static final class InValid implements ValidationResult {

		private final String reason;
		
		public InValid(String reason) {
			this.reason = reason;
		}

		@Override
		public boolean isValid() {
			return false;
		}

		@Override
		public Optional<String> getReason() {
			return Optional.of(reason);
		}

	}

	public static void main(String[] args) {
		
		User user = new User("", 40, "user@example.com");
		UserValidation validation = UserValidation.nameIsNotEmpty().and(UserValidation.emailContainsAtsign());
		ValidationResult result = validation.apply(user);
		result.getReason().ifPresent(System.out::println);
		// System.out.println(result);
	}

}
