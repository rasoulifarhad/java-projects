package com.farhad.example.codekata.fizz_buzz_builder_02;

public class FizzBuzzAction   extends AbstractFizzBuzz {

    public FizzBuzzAction(IFizzBuzz _next) {
        super(_next);
    }

    @Override
    public String convert(int input) {
        return input % 15 == 0 ? "FizzBuzz" : _next.convert(input);
    }
}
