package com.farhad.example.abstractclass.demo01;

public class Manager extends Employee {

    private double bonus;

    public Manager(String aName) {
        super(aName);
        bonus = 0;
    }

    public void setBonus(double aBonus) {
        this.bonus = aBonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    

}
