package com.farhad.example.abstractclass.demo01;

public class Employee {

    private String name;
    private double salary;
    
    public Employee(String aName) {
        this.name = aName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double aSalary) {
        this.salary = aSalary;
    }

    public String getName() {
        return name;
    }

    

}
