package com.farhad.example.functional_interface.default_methode;

public interface Fly {
    
    default void takeOff() {
        System.out.println("Fly::takeOff"); 
    }

    default void land() {
        System.out.println("Fly::land"); 
    }

    default void turn() {
        System.out.println("Fly::turn"); 
    }

    default void cruise() {
        System.out.println("Fly::cruise"); 
    }

    
}
