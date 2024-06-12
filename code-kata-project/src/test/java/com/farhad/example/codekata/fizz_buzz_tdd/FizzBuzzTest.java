package com.farhad.example.codekata.fizz_buzz_tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzTest {

    @Test
    public void givenIntegerOf1ShouldReturnStringOf1() {

        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.convert(1);
        assertEquals("1", actual);
    }
}
