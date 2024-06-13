package com.farhad.example.codekata.fizz_buzz_chain;

public class FizzLink extends FizzBuzz {

    public FizzLink(IFizzBuzz fizzBuzz) {
        super(fizzBuzz);
    }

    @Override
    public String convert(int input) {
        if(input % 3 == 0) {
            return "Fizz";
        }
        return _next.convert(input);
    }


}
