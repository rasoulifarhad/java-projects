package com.farhad.example.design_principles03.basic.university;

public class GraduatedStudent extends Student {


    public GraduatedStudent(String name) {
        super(name);
    }

    public GraduatedStudent(String name , String address) {
        super(name, address);
    }


    @Override
    protected double getGPACutoff() {
        return 3.0;
    }

}
