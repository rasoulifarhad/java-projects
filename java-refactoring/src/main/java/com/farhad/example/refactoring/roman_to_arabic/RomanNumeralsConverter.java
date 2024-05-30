package com.farhad.example.refactoring.roman_to_arabic;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsConverter {


    private static final Map<Character, Integer> romanSymbols =  new HashMap<Character, Integer>(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public static int convert(String roman) {
        int sum = 0;
        int current = 0;
        int previous =0;

        String reverseRoman = getReverseRoman(roman.toUpperCase());
        for (char ch : reverseRoman.toCharArray()) {
            if(doseSymblesContainsRomanCharacter(ch)) {
                current = symbolValue(ch);
                if(current < previous) {
                    sum -= current;
                } else {
                    sum += current;
                }
                previous = current;
            } else {
                throw new IllegalArgumentException(String.format("Illegal roman character %s", ch));
            }
        }

        return sum;
    }

    private static String getReverseRoman(String roman) {
        return new StringBuffer(roman).reverse().toString();
    }

    private static boolean doseSymblesContainsRomanCharacter(char ch) {
        return romanSymbols.containsKey(ch);
    }

    private static Integer symbolValue(char ch) {
        return romanSymbols.get(ch);
    }


}
