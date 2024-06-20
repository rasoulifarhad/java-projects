package com.farhad.example.codekata.bottles_of_beer.demo1;

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
                return verseOfZero();
            case 1:
                return verseOfOne();
            case 2:
                return verseOfTwo();
                    default:
                return highVerse(number);
        }
    }

    private String highVerse(int number) {
        return String.format("%d %s %d %s%n%s %d %s%n", 
            number,
            "bottles of beer on the wall,", 
            number,
            "bottles of beer.",
            "Take one down and pass it around,",
            number - 1,
            "bottles of beer on the wall.");
}

    private String verseOfTwo() {
        return String.format("%s %s%n%s %s%n", 
            "2 bottles of beer on the wall,", 
             "2 bottles of beer.",
            "Take one down and pass it around,",
            "1 bottle of beer on the wall.");
    }

    private String verseOfOne() {
        return String.format("%s %s%n%s %s%n", 
            "1 bottle of beer on the wall,", 
             "1 bottle of beer.",
            "Take it down and pass it around,",
            "no more bottles of beer on the wall.");
    }

    private String verseOfZero() {
        return String.format("%s %s%n%s %s%n", 
            "No more bottles of beer on the wall,", 
             "no more bottles of beer.",
            "Go to the store and buy some more,",
            "99 bottles of beer on the wall.");
    }

    public static void main(String[] args) {
        Bottles bottles = new Bottles();
        System.out.println();
        System.out.println(bottles.song());
    }
}
