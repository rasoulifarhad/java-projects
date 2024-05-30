package com.farhad.example.refactoring.roman_to_arabic;

public class RomanNumeralsConverter {

    public static int convert(String roman) {
        int sum = 0;
        for (char ch : roman.toCharArray()) {
            if(ch == 'I'){
                sum++;
            } else if(ch == 'V') {
                sum += 5;
            } else if(ch == 'X') {
                sum += 10;
            } else {
                throw new IllegalArgumentException();
            }
        }

        return sum;
    }


}
