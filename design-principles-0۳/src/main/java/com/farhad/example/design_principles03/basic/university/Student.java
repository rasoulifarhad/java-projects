package com.farhad.example.design_principles03.basic.university;

import lombok.Getter;
import lombok.Setter;

public abstract class Student {

    private static double minimumGPA;
    @Getter
    @Setter
    private String name;
    
    @Getter
    @Setter
    private String address;

    public Student() {

    }

    public Student(String studentName) {
        this(studentName, null);
    }   

    public Student(String studentName, String studentAddress) {
        this.name = studentName;
        this.address = studentAddress;
    }   

    public static void setMinimumGPA(double newMinimum) {
        minimumGPA = newMinimum;
    }

    public static double getMinimumGPA() {
        return minimumGPA;
    }


    public boolean isInGoodStanding() {
        return gpa >= getGPACutoff();
    }

    protected abstract double getGPACutoff();

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

    @Override
    public String toString() {
        return String.format("Name %s Address %s  GPA %.2f",name, address, gpa);
    }

    public boolean equals(Object anObject) {
        Student student = (Student) anObject; 
        return student.name.equals(name) && student.address.equals(address);
    }

    public static void main(String[] args) {
        
        Student aStudent = new UndergraduatedStudent("me");
        Student.setMinimumGPA(2.0);;
        Course aCourse = new Course("1", "name");
        aStudent.addCourse(aCourse);

        // The implied meaning is that the student has completed the 
        // course (aCourse) with a grade of ’B’.
        // compute the new GPA for the student using the information presumably 
        // in the course (such as number of credits) and the number of points for 
        // a grade of ‘B’.
        aStudent.assignGrade(aCourse, 'B');
        System.out.println(aStudent.getGpa());

        Student student1 = new UndergraduatedStudent("Tom", "1 Main Street");
        Student student2 = new UndergraduatedStudent("Tom", "1 Main Street");
        System.out.println(student1.equals(student2));

    }
}
