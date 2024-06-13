package com.farhad.example.codekata.fizz_buzz_tdd;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {


    private FizzBuzz fizzBuzz;

    @BeforeEach
    public void setup() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void givenInputReturnStringOfInput() {
        Map<Integer, String> regressionValues = new HashMap<Integer, String>() {
            {put(1,"1");
             put(2,"2");}};
        int sourceInput = 1 + new Random().nextInt(2);
        String expected = regressionValues.get(sourceInput);
        String actual = fizzBuzz.trasnsform(sourceInput);
        assertEquals(expected, actual);
    }

    @Test
    public void givenInput3ReturnsFizz() {
        int sourceInput = 1 * 3;
        String expected = "Fizz";

        String actual = fizzBuzz.trasnsform(sourceInput);
        assertEquals(expected, actual);
    }

    @Test
    public void givenInput6ReturnsFizz() {
        int sourceInput = 2 * 3;
        String expected = "Fizz";

        String actual = fizzBuzz.trasnsform(sourceInput);
        assertEquals(expected, actual);
    }

}
