package com.farhad.example.codekata.fizz_buzz_builder_02;

public class FizzAction  extends AbstractFizzBuzz {

    public FizzAction(IFizzBuzz _next) {
        super(_next);
    }

    @Override
    public String convert(int input) {
        return input % 3 == 0 ? "Fizz" : _next.convert(input);
    }
}
