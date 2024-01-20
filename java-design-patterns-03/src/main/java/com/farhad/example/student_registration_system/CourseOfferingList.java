package com.farhad.example.student_registration_system;

import java.util.ArrayList;
import java.util.List;

public class CourseOfferingList {
	private List<CourseOffering> courseOfferings;

	public CourseOfferingList() {
		courseOfferings = new ArrayList<>();
	}

	public void add(CourseOffering courseOffering) {
		courseOfferings.add(courseOffering);
	}

	public void remove(CourseOffering courseOffering) {
		courseOfferings.remove(courseOffering);
	}
	
}
