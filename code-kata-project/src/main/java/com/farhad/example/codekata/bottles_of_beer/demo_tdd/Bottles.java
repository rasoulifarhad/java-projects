package com.farhad.example.codekata.bottles_of_beer.demo_tdd;

import java.util.StringJoiner;

public class Bottles {

    public String song() {
        return verses(99, 0);
    }

    public String verses(int startVerse, int endVerse) {

        StringJoiner stringJoiner = new StringJoiner("\n");
        for (int v = startVerse; v >= endVerse ; v--) {
            stringJoiner.add(verse(v));
        }
        return stringJoiner.toString();
    }

    public String verse(int number) {
        switch (number) {
            case 0:
                return (
                    "No more bottles of beer on the wall, " + 
                    "no more bottles of beer.\n" +
                    "Go to the store and buy some more, " +
                    "99 bottles of beer on the wall.\n"
                );
            case 1:
                return (
                    "1 bottle of beer on the wall, " +
                    "1 bottle of beer.\n" +
                    "Take it down and pass it around, " +
                    "no more bottles of beer on the wall.\n"
                );
            case 2:
                return (
                    "2 bottles of beer on the wall, " +
                    "2 bottles of beer.\n" +
                    "Take one down and pass it around, " +
                    "1 bottle of beer on the wall.\n"
                );
            default:
                return (
                    number + " bottles of beer on the wall, " +
                    number + " bottles of beer.\n" +
                    "Take one down and pass it around, " +
                    (number - 1) + " bottles of beer on the wall.\n"
                );
        }
    }


}
