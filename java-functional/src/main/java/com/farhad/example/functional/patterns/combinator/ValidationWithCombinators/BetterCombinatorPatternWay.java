package com.farhad.example.functional.patterns.combinator.ValidationWithCombinators;

import java.util.Objects;
import java.util.function.Function;
// See https://gtrefs.github.io/code/combinator-pattern/
//
// A user is valid if and only if a given set of rules are satisfied. 
// A rule describes the properties a user must have. 
// Different rules can be combined to more complex ones. 
// Applying a rule yields a validation result which describes the outcome. 

// Primitives are translated to static methods and combinators to default methods. 
public class BetterCombinatorPatternWay {

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

