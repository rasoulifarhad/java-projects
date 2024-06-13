package com.farhad.example.codekata.fizz_buzz_chain;

public class FizzBuzz implements IFizzBuzz {

    protected IFizzBuzz _next;

    public FizzBuzz() {
        this(new FizzBuzzLink(
                new BuzzLink(
                        new FizzLink(
                                new ToStringLink()))));
    }

    public FizzBuzz(IFizzBuzz fizzBuzz) {
        this._next = fizzBuzz;
    }

    public String convert(int input) {
        return _next.convert(input);
    }

}
