package com.farhad.example.codekata.fizz_buzz_builder_02;

public class BuzzAction extends AbstractFizzBuzz {

    public BuzzAction(IFizzBuzz _next) {
        super(_next);
    }

    @Override
    public String convert(int input) {
        return input % 5 == 0 ? "Buzz" : _next.convert(input);
    }

}
