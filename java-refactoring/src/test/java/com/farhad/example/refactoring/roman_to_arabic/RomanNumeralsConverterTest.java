package com.farhad.example.refactoring.roman_to_arabic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RomanNumeralsConverterTest {

    @Test
    public void isJunitWorking() {
        assertTrue(true);
    }

    @Test
    public void convertsSingleRomanDigit() {
        RomanNumeralsConverter converter = new RomanNumeralsConverter();
        String romanNumeral = "I";
        int  arabicNumber = converter.convert(romanNumeral);
        assertEquals(arabicNumber, 1);
    }
}
