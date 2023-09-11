package com.farhad.example.object_instantiation.factory_method;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class PersonValidationTest {

	private PersonValidation personValidation = new PersonValidation();

	@Test
	public void given_personWithNotNullBirthDate_when_validate_then_true() {
		//given
		Person person = Person.newPersonWithBirthDate(LocalDate.of(1999, 9, 9));
		//when
		boolean valid = personValidation.validate(person);
		//then
		assertTrue(valid);
	}
}
