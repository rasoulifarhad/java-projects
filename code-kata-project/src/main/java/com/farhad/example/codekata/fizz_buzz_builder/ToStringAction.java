package com.farhad.example.codekata.fizz_buzz_builder;

public class ToStringAction implements IFizzBuzz {

    @Override
    public String convert(int input) {
        return String.valueOf(input);
    }

}
