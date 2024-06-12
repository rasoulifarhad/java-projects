package com.farhad.example.codekata.fizz_buzz_tdd;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {


    private FizzBuzz fizzBuzz;

    @BeforeEach
    public void setup() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void givenInt1ShouldReturnString1() {
        assertEquals("1", fizzBuzz.trasnsform(1));
    }
}
