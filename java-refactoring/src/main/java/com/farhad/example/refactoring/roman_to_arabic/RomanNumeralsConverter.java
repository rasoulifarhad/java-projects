package com.farhad.example.refactoring.roman_to_arabic;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsConverter {


    private static final Map<Character, Integer> romanSymbols =  new HashMap<Character, Integer>(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
        }
    };

    public static int convert(String roman) {
        roman = roman.toUpperCase();
        int sum = 0;
        int current = 0;
        int previous =0;

        for (char ch : roman.toCharArray()) {
            if(romanSymbols.containsKey(ch)) {
                current = symbolValue(ch);
                if(previous >= current) {
                    sum += current;
                } else {
                    sum -= previous;
                    sum += (current - previous);
                }
                previous = current;
            } else {
                throw new IllegalArgumentException(String.format("Illegal roman character %s", ch));
            }
        }

        return sum;
    }

    private static Integer symbolValue(char ch) {
        return romanSymbols.get(ch);
    }


}
