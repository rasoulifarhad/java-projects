package com.farhad.example.refactoring.roman_to_arabic;

public class RomanNumeralsConverter {

    public static int convert(String roman) {
        if (roman.equals("I")){
            return 1;
        }
        if (roman.equals("II")){
            return 2;
        }
        if (roman.equals("III")){
            return 3;
        }
        if (roman.equals("V")) {
            return 5;
        }
        if (roman.equals("X")) {
                return 10;
        }
        throw new IllegalArgumentException();
    }


}
