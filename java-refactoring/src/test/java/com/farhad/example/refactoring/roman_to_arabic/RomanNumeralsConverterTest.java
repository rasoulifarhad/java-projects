package com.farhad.example.refactoring.roman_to_arabic;

import static com.farhad.example.refactoring.roman_to_arabic.RomanNumeralsConverter.convert;
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
        assertEquals(convert("I"), 1);
    }

    @Test
    public void convertII() {
        assertEquals(convert("II"), 2);
    }

    @Test
    public void convertIII() {
        assertEquals(convert("III"), 3);
    }

    @Test
    public void convertV() {
        assertEquals(convert("V"), 5);
    }

    @Test
    public void convertVI() {
        assertEquals(convert("VI"), 6);
    }

    @Test
    public void convertIV() {
        assertEquals(convert("IV"), 4);
    }

    @Test
    public void convertX() {
        assertEquals(convert("X"), 10);
    }


}
