package com.farhad.example.codekata.bottles_of_beer.demo_tdd;

public class Bottles {

    public String verse(int number) {
        if(number == 2) {
            return (
                number + " bottles of beer on the wall, " +
                number + " bottles of beer.\n" +
                "Take one down and pass it around, " +
                (number-1) + " bottle of beer on the wall.\n"
            );
        }
        return (
            number + " bottles of beer on the wall, " +
            number + " bottles of beer.\n" +
            "Take one down and pass it around, " +
            (number-1) + " bottles of beer on the wall.\n"
        );
    }
    

}
