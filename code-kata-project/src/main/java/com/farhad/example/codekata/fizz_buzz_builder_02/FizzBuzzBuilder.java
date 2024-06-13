package com.farhad.example.codekata.fizz_buzz_builder_02;

public class FizzBuzzBuilder implements IFizzBuzzBuilder {

    @Override
    public IFizzBuzz fizzBuzz() {
        return new FizzBuzzAction(
            new BuzzAction(
                new FizzAction(
                    new ToStringAction())));
    }

}
