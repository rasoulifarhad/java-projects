package com.farhad.example.codekata.bottles_of_beer.demo_tdd;

public class Bottles {

    public String verse(int number) {
        int n;
        if(number == 99) {
            n = 99;
            return (
                n + " bottles of beer on the wall, " +
                n + " bottles of beer.\n" +
                "Take one down and pass it around, " +
                (n-1) + " bottles of beer on the wall.\n"
            );
        }
        if(number == 3) {
            n = 3;
            return (
                n + " bottles of beer on the wall, " +
                n + " bottles of beer.\n" +
                "Take one down and pass it around, " +
                (n-1) + " bottles of beer on the wall.\n"
            );
        }
        return "";
    }
    

}
