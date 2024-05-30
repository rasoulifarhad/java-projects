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
        int sum = 0;
        for (char ch : roman.toCharArray()) {
            if(romanSymbols.containsKey(ch)) {
                sum += romanSymbols.get(ch);
            } else {
                throw new IllegalArgumentException(String.format("Illegal roman character %s", ch));
            }
        }

        return sum;
    }


}
