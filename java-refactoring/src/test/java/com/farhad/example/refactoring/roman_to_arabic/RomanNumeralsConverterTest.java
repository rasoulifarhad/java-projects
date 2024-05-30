package com.farhad.example.refactoring.roman_to_arabic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RomanNumeralsConverterTest {

    private RomanNumeralsConverter c;

    @BeforeEach
    public void setup() {
        c = new RomanNumeralsConverter();
    }

    @Test
    public void isJunitWorking() {
        assertTrue(true);
    }

    @Test
    public void convertI() {
        assertEquals(c.convert("I"), 1);
    }

    @Test
    public void convertV() {
        assertEquals(c.convert("V"), 5);
    }

    @Test
    public void convertX() {
        assertEquals(c.convert("X"), 10);
    }
}
