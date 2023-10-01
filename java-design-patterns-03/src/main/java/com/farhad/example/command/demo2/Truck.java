package com.farhad.example.command.demo2;

public class Truck implements Vehicle {
    
    @Override
    public void start() {
        System.out.println("Starting Truck...");    
    }

    @Override
    public void stop() {
        System.out.println("Stoping Truck...");    
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating Truck...");
    }

    @Override
    public void decelerate() {
      System.out.println("Decelerating truck...");
    }    
}
