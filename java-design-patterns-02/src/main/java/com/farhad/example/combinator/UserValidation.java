package com.farhad.example.combinator;

import static com.farhad.example.combinator.ValidationResult.ValidationSupport.valid;

import java.util.function.Function;

public interface UserValidation extends Function<User, ValidationResult> {
	static ValidationResult create(User user) {
		throw new UnsupportedOperationException();
	}

	UserValidation nameIsNotEmpty = user -> 
			user.getName().trim().isEmpty() ? 
					new ValidationResult.Invalid("User name is empty") : 
					valid();
	UserValidation emailContainsAtSign = user -> 
			user.getEmail().contains("@") ? 
					valid() :
					new ValidationResult.Invalid("Email is not valid") ;
	default UserValidation and(UserValidation other) {
		return user -> {
			final ValidationResult result = this.apply(user);
			return result.isValid() ? other.apply(user) : result;
		};
	}
}
