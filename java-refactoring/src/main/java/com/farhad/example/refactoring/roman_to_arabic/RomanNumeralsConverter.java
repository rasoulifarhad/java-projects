package com.farhad.example.refactoring.roman_to_arabic;

public class RomanNumeralsConverter {

    public static int convert(String roman) {
        if (roman.equals("I")){
            return 1;
        } else if (roman.equals("V")) {
            return 5;
        } else {
            return 10;
        }
    }


}
