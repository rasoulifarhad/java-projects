package com.farhad.example.java8idioms.funcalttoforloop;

import java.util.stream.IntStream;

public class FunctionalAlternativesToForLoop {
    
    public static void main(String[] args) {

        complexCodeForSimpleTask();

        simpleCodeForSimpleTask();
    }

    private static void complexCodeForSimpleTask() {
        System.out.println("Get set...");
        for (int i = 1; i < 4; i++) {
            System.out.println(i + "...");
        }
    }

    private static void simpleCodeForSimpleTask() {
        System.out.println("Get set...");
        IntStream
            .range(1, 4)
            .forEach(value -> System.out.println(value + "..."));
    }
}
