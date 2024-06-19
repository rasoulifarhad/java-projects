package com.farhad.example.design_principles03.basic.university;

public class UndergraduatedStudent extends Student {

    public UndergraduatedStudent(String name) {
        super(name);
    }

    public UndergraduatedStudent(String name , String address) {
        super(name, address);
    }

    @Override
    protected double getGPACutoff() {
        return 2.0;
    }

}
