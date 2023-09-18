package com.farhad.example.combinator;

import static com.farhad.example.combinator.ValidationResult.inValid;
import static com.farhad.example.combinator.ValidationResult.ValidationSupport.valid;

public interface NameValidations extends UserValidation {
	
	default UserValidation nameIsUpperCase() {
		return user -> {
			String message = String.format("User %s must be named in all upper case.",user.getName());
			return user.getName().chars().allMatch(c -> c >= 65 && c<= 95 ) ? valid() : inValid(message) ;
		};
	}
}
