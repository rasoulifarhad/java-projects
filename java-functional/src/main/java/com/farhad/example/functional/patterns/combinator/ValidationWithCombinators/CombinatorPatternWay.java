package com.farhad.example.functional.patterns.combinator.ValidationWithCombinators;

import java.util.Objects;
import java.util.function.Function;

// See https://gtrefs.github.io/code/combinator-pattern/
//
// A user is valid if and only if a given set of rules are satisfied. 
// A rule describes the properties a user must have. 
// Different rules can be combined to more complex ones. 
// Applying a rule yields a validation result which describes the outcome. 

public class CombinatorPatternWay {

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
