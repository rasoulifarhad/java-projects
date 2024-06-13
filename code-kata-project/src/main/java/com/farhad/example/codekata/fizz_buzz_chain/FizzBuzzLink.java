package com.farhad.example.codekata.fizz_buzz_chain;

public class FizzBuzzLink extends FizzBuzz {

    public FizzBuzzLink(IFizzBuzz fizzBuzz) {
        super(fizzBuzz);
    }

    @Override
    public String convert(int input) {
        if(input % 15 == 0) {
            return "FizzBuzz";
        }
        return _next.convert(input);
    }
}
