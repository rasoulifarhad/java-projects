package com.farhad.example.design_principles03.basic.university;

import lombok.Getter;
import lombok.Setter;

public class Student {

    @Getter
    @Setter
    private String name;

    // grade point average
    // it changes when a student gets a grade for a course.
    @Getter
    private double gpa;

    public void addCourse(Course newCourse) {

    }

    private void computeGPA() {

    }

    public void assignGrade(Course aCourse, char newGrade) {
        computeGPA();
    }


}
