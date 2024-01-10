package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.builder.better;

import lombok.Getter;

@Getter
public class Student extends Person {

	private String degree;
	private String hobby;

	
	public Student(StudentBuilder builder) {
		super(builder);
		this.degree = builder.degree;
		this.hobby = builder.hobby;
	}


	public static class StudentBuilder extends PersonBuilder<StudentBuilder> {

		private String degree;
		private String hobby;

		public StudentBuilder(String firstName, String lastName, String degree) {
			super(firstName, lastName);
			this.degree = degree;
		}

	
		public StudentBuilder withHobby(String hobby) {
			this.hobby = hobby;
			return this;
		}

		public Student build() {
			Student student = new Student(this);
			return student;
		}
	}
}
