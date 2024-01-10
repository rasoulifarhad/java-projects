package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.builder.better;

import org.junit.jupiter.api.Test;

import com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.builder.better.Student.StudentBuilder;

public class StudentTest {

	@Test
	public void studentBuilderTest() {
		StudentBuilder builder = new StudentBuilder("first", "last");

		// Student student = builder.withAadhar(12345)
		// 		.withHobby("hobby").build();  // compileError
	}
}
