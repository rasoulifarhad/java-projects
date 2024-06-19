package com.farhad.example.design_principles03.basic.university;

import lombok.Getter;
import lombok.Setter;

public class Student {

    @Getter
    @Setter
    private String name;
    
    @Getter
    @Setter
    private String address;

    public Student(String studentName) {
        this(studentName, null);
    }   

    public Student(String studentName, String studentAddress) {
        this.name = studentName;
        this.studentAddress = studentAddress;
    }   

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


    public static void main(String[] args) {
        
        Student aStudent = new Student("me");
        Course aCourse = new Course();
        aStudent.addCourse(aCourse);

        // The implied meaning is that the student has completed the 
        // course (aCourse) with a grade of ’B’.
        // compute the new GPA for the student using the information presumably 
        // in the course (such as number of credits) and the number of points for 
        // a grade of ‘B’.
        aStudent.assignGrade(aCourse, 'B');
        System.out.println(aStudent.getGpa());
    }
}
