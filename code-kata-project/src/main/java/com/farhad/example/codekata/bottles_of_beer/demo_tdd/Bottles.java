package com.farhad.example.codekata.bottles_of_beer.demo_tdd;

public class Bottles {

    public String verses(int startVerse, int endVerse) {
        return 
            "99 bottles of beer on the wall, " +
            "99 bottles of beer.\n" +
            "Take one down and pass it around, " +
            "98 bottles of beer on the wall.\n" +
            "\n" +
            "98 bottles of beer on the wall, " +
            "98 bottles of beer.\n" +
            "Take one down and pass it around, " +
            "97 bottles of beer on the wall.\n";
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
