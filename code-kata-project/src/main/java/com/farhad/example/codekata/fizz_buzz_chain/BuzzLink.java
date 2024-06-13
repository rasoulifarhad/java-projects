package com.farhad.example.codekata.fizz_buzz_chain;

public class BuzzLink extends FizzBuzz {

    public BuzzLink(IFizzBuzz fizzBuzz) {
        super(fizzBuzz);
    }

    @Override
    public String convert(int input) {
        if(input % 5 == 0) {
            return "Buzz";
        }
        return _next.convert(input);
    }

}
