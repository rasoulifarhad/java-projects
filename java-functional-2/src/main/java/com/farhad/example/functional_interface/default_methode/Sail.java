package com.farhad.example.functional_interface.default_methode;

public interface Sail {
    
    default void cruise() {
        System.out.println("Sail:cruise");
    }

    default void turn() {
        System.out.println("Sail::turn");
    }
}
