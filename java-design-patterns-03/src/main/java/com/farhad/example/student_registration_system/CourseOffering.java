package com.farhad.example.student_registration_system;

public class CourseOffering {

	private Professor professor;

	public void addProfessor(Professor professor) {
		this.professor = professor;
	}

	public void removeProfessor(Professor professor) {
		this.professor = null;
	}

	public boolean isProfessorAssigned() {
		return professor != null;
	}
}
