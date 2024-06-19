package com.farhad.example.design_principles03.basic.university;

public class StudentArrayList implements StudentList {

    private Student [] students;
    private int initialCapacity;

    private int first;
    private int count;
    
    public StudentArrayList() {
        this(10);
    }

    public StudentArrayList(int capacity) {
        this.students = new Student[capacity];
        this.initialCapacity = capacity;
    }

    @Override
    public void add(Student student) {
        if(count == students.length) {
            reallocate(count * 2);
        }
        int last = (first + count) % students.length;
        students[last] = student;
        count++;
    }


    public Student get(int index) {
        if(index >= 0 && index < count ) {
            return students[index];
        }
        return null;
    }

    public int size() {
        return count;
    }

    @Override
    public void delete(String studentName) {
        for (int index = first, counter = 0; counter < count; counter++, index = (index + 1) % students.length) {
            if(students[index].getName().equals(studentName)) {
                students[index] = students[(first + count - 1) % students.length];
                students[(first + count - 1) % students.length] = null;
                count--;
                return;
            }
        }

    }

    private void reallocate(int size) {
        Student [] temp = new Student[size];
        if(first + count >= students.length) {
            int count1 = students.length - first;
            int count2 = count1 - count1;
            System.arraycopy(students, first, temp, 0, count1);
            System.arraycopy(students, first + count1, temp, count1, count2);

        } else {
            System.arraycopy(students, first, temp, 0, count);
        }
        students = temp;
        first = 0;
    }

    @Override
    public void print() {
        for (int index = first, counter = 0; counter < count; counter++, index = (index + 1) % students.length) {
            System.out.println(students[index]);
        }
    }

}
