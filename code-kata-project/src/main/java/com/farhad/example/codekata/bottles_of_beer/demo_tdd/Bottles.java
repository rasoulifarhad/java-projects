package com.farhad.example.codekata.bottles_of_beer.demo_tdd;

import static java.util.stream.Collectors.joining;

import java.util.stream.IntStream;

public class Bottles {

    public String song() {
        return verses(99, 0);
    }

    public String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(endVerse, startVerse)
                    .map(i -> startVerse - i + endVerse )
                    .mapToObj(v -> verse(v))
                    .collect(joining("\n"));
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
            case 6:
                return (
                    "1 six-pack of beer on the wall, " +
                    "1 six-pack of beer.\n" +
                    "Take one down and pass it around, " +
                    "5 bottles of beer on the wall.\n"
                );
            case 7:
                return (
                    "7 bottles of beer on the wall, " +
                    "7 bottles of beer.\n" +
                    "Take one down and pass it around, " +
                    "1 six-pack of beer on the wall.\n"
                );
            case 2:
                return (
                    number + " bottles of beer on the wall, " +
                    number + " bottles of beer.\n" +
                    "Take one down and pass it around, " +
                    (number - 1) + " " + container(number-1) + " of beer on the wall.\n"
                );
            default:
                return (
                    number + " bottles of beer on the wall, " +
                    number + " bottles of beer.\n" +
                    "Take one down and pass it around, " +
                    (number - 1) + " " + container(number-1) + " of beer on the wall.\n"
                );
        }
    }

    String container(int nmumber) {
        if(nmumber == 1) {
            return "bottle";
        } else {
            return "bottles";
        }
    }
}
