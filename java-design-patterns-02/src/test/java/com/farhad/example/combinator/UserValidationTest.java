package com.farhad.example.combinator;

import static com.farhad.example.combinator.UserValidation.emailContainsAtSign;
import static com.farhad.example.combinator.UserValidation.nameIsNotEmpty;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserValidationTest {

	@Test
	public void given_userWithValidEmailAndNoneEmptyName_when_validated_then_success() {
		//given
		final User user = new User("anyName", 45, "anyEmail@example.com");
		// when
		UserValidation validation = nameIsNotEmpty.and(emailContainsAtSign);
		//then
		assertTrue(validation.apply(user).isValid());
	}

	@Test
	public void given_userWithoutEmail_when_validated_then_invalid() {
		//given
		final User user = new User("anyName", 45, "");
		// when
		UserValidation validation = nameIsNotEmpty.and(emailContainsAtSign);
		ValidationResult result = validation.apply(user);
		//then
		assertFalse(result.isValid());
		assertThat(result.getReason()).isEqualTo("Email is not valid");
	}

	@Test
	public void given_userWithUpperCaseName_when_validated_then_valid() {
		//given
		final User user = new User("ANYNAME", 45, "anyNEmail@example.com");
		NameValidations nameValidations = (NameValidations)UserValidation::create;
		AgeValidations ageValidations = (AgeValidations)UserValidation::create;
		// when
		UserValidation validation = nameValidations.nameIsUpperCase().and(ageValidations.olderThan(30));
		ValidationResult result = validation.apply(user);
		//then
		assertTrue(result.isValid());
	}

	@Test
	public void given_userWithoutUpperCaseName_when_validated_then_invalid() {
		//given
		final User user = new User("ANYName", 45, "anyNEmail@example.com");
		NameValidations nameValidations = (NameValidations)UserValidation::create;
		AgeValidations ageValidations = (AgeValidations)UserValidation::create;
		// when
		UserValidation validation = nameValidations.nameIsUpperCase().and(ageValidations.olderThan(30));
		ValidationResult result = validation.apply(user);
		//then
		assertFalse(result.isValid());
	}

}
