package com.farhad.example.object_instantiation.builder;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class PersonTest {

	@Test
	public void given_personFrom1999_when_calculateAgeFrom2019_then_return21() {
		//given
		Person person = Person.builder().birthDate(LocalDate.of(1999, 9, 9)).build();

		Person personCopy = Person.builder().birthDate(LocalDate.of(1999, 9, 9)).build();
		//when
		Integer age = person.calculateAgeFrom(LocalDate.of(2019, 9, 9));
		//then
		assertThat(age).isEqualTo(20);
		assertThat(person).isEqualTo(personCopy);
	}

}
