package com.farhad.example.combinator;

import static com.farhad.example.combinator.ValidationResult.inValid;
import static com.farhad.example.combinator.ValidationResult.ValidationSupport.valid;


public interface AgeValidations extends UserValidation {

	default UserValidation olderThan(int age) {
		return user -> {
			String message = String.format("User %s must be older than %d", user, age);
			return user.getAge() > age ? valid() : inValid(message);
		};
	}
	
}
