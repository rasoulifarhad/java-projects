package com.farhad.example.design_principles03.basic.university;

import lombok.Getter;
import lombok.Setter;

public class StudentLinkedList implements StudentList {

    private StudentNode head;

    @Getter
    @Setter
    private class StudentNode {

        private Student data;
        private StudentNode next;

        public StudentNode(Student student, StudentNode initialLink) {
            this.data = student;
            this.next = initialLink;
        }

        
    }

    @Override
    public void add(Student student) {
        head = new StudentNode(student, head);
    }

    @Override
    public void delete(String studentName) {
        if (head == null){
            return;
        }
        if(head.getData().getName().equals(studentName)) {
            head = head.getNext();
        } else {
            for (StudentNode temp = head.getNext(), previous = head; temp != null; temp = temp.getNext()) {
                if(temp.getData().getName().equals(studentName)) {
                    previous.setNext(temp.getNext());
                    return;
                }
            }
        }
    }

    @Override
    public void print() {
        System.out.print("List: ");
        for (StudentNode temp = head; temp != null; temp = temp.getNext()) {
            System.out.println(temp.getData() + "  ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        
        StudentList students;
        students = new StudentLinkedList();
        Student s1 = new UndergraduatedStudent("s1", "address1");
        students.add(s1);
        s1 = new UndergraduatedStudent("s2", "address2");
        students.add(s1);
        students.print();

    }
}
