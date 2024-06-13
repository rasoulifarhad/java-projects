package com.farhad.example.codekata.fizz_buzz_builder_02;

public class Consumer {

    private IFizzBuzz fizzBuzz;

    
    public Consumer(IFizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }

    public void blah() {
        System.out.println(fizzBuzz.convert(30));
        System.out.println(fizzBuzz.convert(25));
        System.out.println(fizzBuzz.convert(6));
        System.out.println(fizzBuzz.convert(2));
    }

    public static void main(String[] args) {
        new Consumer(new FizzBuzz()).blah();
    }
}
