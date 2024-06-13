package com.farhad.example.codekata.fizz_buzz_chain;

public class Appp {

    public static void main(String[] args) {
        IFizzBuzz i = new ToStringLink();
        IFizzBuzz f = new FizzLink(i);
        IFizzBuzz b = new BuzzLink(f);
        IFizzBuzz fb = new FizzBuzzLink(b);
        FizzBuzz fizzBuzz = new FizzBuzz(fb);
        System.out.println( fizzBuzz.convert(30));
        System.out.println( fizzBuzz.convert(25));
        System.out.println( fizzBuzz.convert(6));
        System.out.println( fizzBuzz.convert(11));

        IFizzBuzz links = new FizzBuzzLink(
            new BuzzLink(
                new FizzLink(
                    new ToStringLink())));
        System.out.println(links.convert(25));
    }
}
