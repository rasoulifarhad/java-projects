package com.farhad.example.tdd;

public class App {

    public static void main(String[] args) {
        int firstNumber = Integer.parseInt(args[0]);
        int secondNumber = Integer.parseInt(args[1]);

        int result = new Multiplication(firstNumber, secondNumber).perform();

        System.out.println("Result is: " + result);
    }

}
