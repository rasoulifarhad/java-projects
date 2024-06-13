package com.farhad.example.codekata.fizz_buzz_builder;

public class Consumer {

    private IFizzBuzzBuilder fizzBuzzBuilder;

    public Consumer(IFizzBuzzBuilder fizzBuzzBuilder) {
        this.fizzBuzzBuilder = fizzBuzzBuilder;
    }

    public void blah() {
        IFizzBuzz fizzBuzz = fizzBuzzBuilder.fizzBuzz();
        System.out.println(fizzBuzz.convert(30));
        System.out.println(fizzBuzz.convert(25));
        System.out.println(fizzBuzz.convert(6));
        System.out.println(fizzBuzz.convert(2));
    }

    public static void main(String[] args) {
        new Consumer(new FizzBuzzBuilder()).blah();
    }
}
