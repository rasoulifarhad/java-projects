package com.farhad.example.refactoring.roman_to_arabic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RomanNumeralsConverterTest {

    private RomanNumeralsConverter converter;

    @BeforeEach
    public void setup() {
        converter = new RomanNumeralsConverter();
    }

    @Test
    public void isJunitWorking() {
        assertTrue(true);
    }

    @Test
    public void convertI() {
        String romanNumeral = "I";
        int  arabicNumber = converter.convert(romanNumeral);
        assertEquals(arabicNumber, 1);
    }

    @Test
    public void convertV() {
        String romanNumeral = "V";
        int  arabicNumber = converter.convert(romanNumeral);
        assertEquals(arabicNumber, 5);
    }
}
