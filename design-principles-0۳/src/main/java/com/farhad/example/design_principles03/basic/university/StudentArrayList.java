package com.farhad.example.design_principles03.basic.university;

public class StudentArrayList implements StudentList {

    private Student [] students;
    private int initialCapacity;
    
    public StudentArrayList() {
        this(10);
    }

    public StudentArrayList(int capacity) {
        this.students = new Student[capacity];
        this.initialCapacity = capacity;
    }

    @Override
    public void add(Student student) {
    }

    @Override
    public void delete(String studentName) {
    }

    @Override
    public void print() {
    }

}
