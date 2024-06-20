package com.farhad.example.codekata.bottles_of_beer.demo_tdd;

public class Bottles {

    public String verse(int number) {
        if(number == 99) {
            return (
                "99 bottles of beer on the wall, " +
                "99 bottles of beer.\n" +
                "Take one down and pass it around, " +
                "98 bottles of beer on the wall.\n"
            );
        }
        if(number == 3) {
            return (
                "3 bottles of beer on the wall, " +
                "3 bottles of beer.\n" +
                "Take one down and pass it around, " +
                "2 bottles of beer on the wall.\n"
            );
        }
        return "";
    }
    

}
