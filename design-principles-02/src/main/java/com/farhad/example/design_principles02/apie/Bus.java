package com.farhad.example.design_principles02.apie;

public class Bus implements VehicleInterface{
    @Override
    public void move() {
        System.out.println("bus moves...");
    }
}