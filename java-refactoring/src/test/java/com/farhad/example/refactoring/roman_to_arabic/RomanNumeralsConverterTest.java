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
        assertEquals(RomanNumeralsConverter.convert("I"), 1);
    }

    @Test
    public void convertV() {
        assertEquals(RomanNumeralsConverter.convert("V"), 5);
    }

    @Test
    public void convertX() {
        assertEquals(RomanNumeralsConverter.convert("X"), 10);
    }
}
