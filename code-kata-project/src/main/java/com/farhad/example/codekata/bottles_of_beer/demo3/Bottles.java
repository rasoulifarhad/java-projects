package com.farhad.example.codekata.bottles_of_beer.demo3;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bottles {

    public String song() {
        return verses(99, 0);
    }

    private String verses(int bottlesAtStart, int bottlesAtEnd) {
         return reverseOrderStream(IntStream.rangeClosed(bottlesAtEnd, bottlesAtStart))
            .mapToObj(b -> verse(b))
            .collect(Collectors.joining("\n"));
    }

    public IntStream reverseOrderStream(IntStream intStream) {
        int [] tempArray = intStream.toArray();
        return IntStream.range(1, tempArray.length + 1)
                    .boxed()
                    .mapToInt(i -> tempArray[tempArray.length - i]);
    }

    private String verse(int number) {
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
                    number +       " bottles of beer on the wall, " +
                    number +       " bottles of beer.\n" +
                    "Take one down and pass it around, " +
                    (number - 1) + " bottles of beer on the wall.\n"
                );
        }
    }

    public static void main(String[] args) {
        Bottles bottles = new Bottles();
        System.out.println();
        System.out.println(bottles.song());
    }
}
