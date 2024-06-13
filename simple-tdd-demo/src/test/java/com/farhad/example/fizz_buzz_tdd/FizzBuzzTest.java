package com.farhad.example.fizz_buzz_tdd;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    @SuppressWarnings("unchecked")
    @Test
    public void givenInputReturnStringOfInput() {
        final Map<Integer, String> regressionValues = new HashMap<Integer, String>() {
            {
             put(1,"1");
             put(2,"2");
             put(4,"4");
            }
        };
        final Map.Entry<Integer, String> entry = 
             regressionValues.entrySet()
                 .toArray(
                     new Map.Entry[0])[new Random().nextInt(3)];
        final String expected = entry.getValue();
        final String actual = fizzBuzz.trasnsform(entry.getKey());
        assertEquals(expected, actual);
    }

    @Test 
    public void givenMultipleOf3ReturnsFizz() {
        final int multiplicand = 3;
        final String expected = "Fizz";
        final List<Integer> multiplierList = Arrays.asList(1, 2, 4);
        final int randIndex = new Random().nextInt(3);
        final int multiplier = multiplierList.get(randIndex);
        final int sourceInput = multiplier * multiplicand;
        final String actual = fizzBuzz.trasnsform(sourceInput);
        assertEquals(expected, actual);
    }

    @Test 
    public void givenMultipleOf5ReturnsFizz() {
        final int multiplicand = 5;
        final String expected = "Buzz";
        final List<Integer> multiplierList = Arrays.asList(1, 2, 4);
        final int randIndex = new Random().nextInt(3);
        final int multiplier = multiplierList.get(randIndex);
        final int sourceInput = multiplier * multiplicand;
        final String actual = fizzBuzz.trasnsform(sourceInput);
        assertEquals(expected, actual);
    }

    @Test 
    public void givenMultipleOf3And5ReturnsFizzBuzz() {
        final int multiplicand = 3 * 5;
        final String expected = "FizzBuzz";
        final List<Integer> multiplierList = Arrays.asList(1, 2, 3);
        final int randIndex = new Random().nextInt(3);
        final int multiplier = multiplierList.get(randIndex);
        final int sourceInput = multiplier * multiplicand;
        final String actual = fizzBuzz.trasnsform(sourceInput);
        assertEquals(expected, actual);
    }
}
