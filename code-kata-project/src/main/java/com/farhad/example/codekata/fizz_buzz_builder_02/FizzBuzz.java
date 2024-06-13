package com.farhad.example.codekata.fizz_buzz_builder_02;

public class FizzBuzz implements IFizzBuzz {

    private IFizzBuzzBuilder fizzBuzzBuilder;

    public FizzBuzz() {
        this(new FizzBuzzBuilder());
    }

    private FizzBuzz(IFizzBuzzBuilder fizzBuzzBuilder) {
        this.fizzBuzzBuilder = fizzBuzzBuilder;
    }

    @Override
    public String convert(int input) {
        return fizzBuzzBuilder.fizzBuzz().convert(input);
    }

}
