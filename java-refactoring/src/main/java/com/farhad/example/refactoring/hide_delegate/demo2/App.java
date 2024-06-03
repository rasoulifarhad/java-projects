package com.farhad.example.refactoring.hide_delegate.demo2;

public class App {

    public static void main(String[] args) {
        Manager aManager = new Manager("manager name");
        Department aDepartment = new Department("charge code", aManager);
        Person aPerson = new Person("person name");
        aPerson.setDepartment(aDepartment);
        Manager manager = aPerson.getManager();
        System.out.println(manager);
    }
}
