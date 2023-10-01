package com.farhad.example.command.demo2;

public class Motorcycle implements Vehicle {

    @Override
    public void start() {
        System.out.println("Starting motorcycle...");    
    }

    @Override
    public void stop() {
        System.out.println("Stoping motorcycle...");    
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating motorcycle...");
    }
   
    @Override
    public void decelerate() {
      System.out.println("Decelerating motorcycle...");
    }    
    
}
