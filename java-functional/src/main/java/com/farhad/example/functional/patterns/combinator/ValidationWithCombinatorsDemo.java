package com.farhad.example.functional.patterns.combinator;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import lombok.EqualsAndHashCode;

// See https://gtrefs.github.io/code/combinator-pattern/
//
// A user is valid if and only if a given set of rules are satisfied. 
// A rule describes the properties a user must have. 
// Different rules can be combined to more complex ones. 
// Applying a rule yields a validation result which describes the outcome. 

public class ValidationWithCombinatorsDemo {
	
	static class OldWay {

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

			public boolean isValid() {
				return nameIsNotEmpty() && emailContainsAtsign();
			}

			private boolean emailContainsAtsign() {
				return email.contains("@");
			}

			private boolean nameIsNotEmpty() {
				return !name.trim().isEmpty();
			}
		}

		public static void main(String[] args) {
			System.out.println(new User("user", 45, "user@example.com").isValid());
		}
	}

	static class CombinatorPatternWay {

		public interface UserValidation extends Function<User, Boolean> {

		}
		
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

		public static void main(String[] args) {
			UserValidation nameIsNotEmpty = user -> !user.name.trim().isEmpty();
			UserValidation emailContainsAtsign = user -> user.email.contains("@");
			User user = new User("user", 40, "user@example.com");
			System.out.println( (nameIsNotEmpty.apply(user) && emailContainsAtsign.apply(user)) ); 
		}
	}

	// Primitives are translated to static methods and combinators to default methods. 
	static class BetterCombinatorPatternWay {

		public interface UserValidation extends Function<User, Boolean> {

			static UserValidation nameIsNotEmpty() {
				return user -> !user.name.trim().isEmpty();
			}

			static UserValidation emailContainsAtsign() {
				return user -> user.email.contains("@");
			}

			default UserValidation and(UserValidation other) {
				return user ->  this.apply(user) && other.apply(user);
			}
		}
		
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

		public static void main(String[] args) {
			User user = new User("user", 40, "user@example.com");
			System.out.println(UserValidation.nameIsNotEmpty().and(UserValidation.emailContainsAtsign()).apply(user));

		}
	}

	static class ValidationResultReasoning {


		public interface ValidationResult {

			// static ValidationResult valid() {

			// }

			// static ValidationResult invalid(String reason) {

			// }

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

		// private static final class ValidationSupport {
			
		// 	private static final ValidationResult valid = new ValidationResult(){
				
		// 		public boolean isValid() { 
		// 			return true; 
		// 		}
				
		// 		public Optional<String> getReason() { 
		// 			return Optional.empty(); 
		// 		}
		// 	};
		
		// 	static ValidationResult valid(){
		// 		return valid;
		// 	}
		// }
		
	}

}
