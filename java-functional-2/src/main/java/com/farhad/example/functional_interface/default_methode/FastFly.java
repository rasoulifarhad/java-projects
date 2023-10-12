package com.farhad.example.functional_interface.default_methode;

public interface FastFly extends Fly {
    
    default void takeOff() {
        System.out.println("FastFly::takeOff");
    }
}
