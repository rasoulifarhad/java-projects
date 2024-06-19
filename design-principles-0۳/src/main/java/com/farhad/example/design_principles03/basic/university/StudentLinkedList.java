package com.farhad.example.design_principles03.basic.university;

public class StudentLinkedList implements StudentList {

    @Override
    public void add(Student student) {
    }

    @Override
    public void delete(Student student) {
    }

    @Override
    public void print() {
    }

    public static void main(String[] args) {
        
        StudentList students;
        students = new StudentLinkedList();
        Student s1 = new Student("s1", "address1");
        students.add(s1);
        s1 = new Student("s2", "address2");
        students.add(s1);
        students.print();

    }
}
