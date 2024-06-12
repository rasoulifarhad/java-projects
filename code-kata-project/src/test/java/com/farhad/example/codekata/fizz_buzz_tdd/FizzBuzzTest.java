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
        int valueToTransform = 1;
        String transformedValue = "1";
        String actual = fizzBuzz.trasnsform(valueToTransform);
        assertEquals(transformedValue, actual);
    }

    @Test
    public void givenInt2ShouldReturnString2() {
        int valueToTransform = 2;
        String transformedValue = "2";
        String actual = fizzBuzz.trasnsform(valueToTransform);
        assertEquals(transformedValue, actual);
    }
}
