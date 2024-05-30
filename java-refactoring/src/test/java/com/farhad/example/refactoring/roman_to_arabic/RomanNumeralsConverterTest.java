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
    public void convertI() {
        RomanNumeralsConverter converter = new RomanNumeralsConverter();
        String romanNumeral = "I";
        int  arabicNumber = converter.convert(romanNumeral);
        assertEquals(arabicNumber, 1);
    }

    @Test
    public void convertV() {
        RomanNumeralsConverter converter = new RomanNumeralsConverter();
        String romanNumeral = "V";
        int  arabicNumber = converter.convert(romanNumeral);
        assertEquals(arabicNumber, 5);
    }
}
