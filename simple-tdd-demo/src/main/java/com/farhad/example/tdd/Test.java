package com.farhad.example.tdd;

public class Test {

    public static void main(String[] args) {

        Multiplication multiplication = new Multiplication(3, 7);
        int result = multiplication.perform();
        if (result != 21 ) {
            throw new RuntimeException("Failed! Expected 21 but was: " + result);
        }
    }
}
