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

    @SuppressWarnings("unchecked")
    @Test
    public void givenInputReturnStringOfInput() {
        Map<Integer, String> regressionValues = new HashMap<Integer, String>() {
            {
             put(1,"1");
             put(2,"2");
             put(4,"4");
            }
        };
        Map.Entry<Integer, String> entry = 
             regressionValues.entrySet()
                 .toArray(
                     new Map.Entry[0])[new Random().nextInt(3)];
        String expected = entry.getValue();
        String actual = fizzBuzz.trasnsform(entry.getKey());
        assertEquals(expected, actual);
    }

    @SuppressWarnings("unchecked")
    @Test 
    public void givenMultipleOf3ReturnsFizz() {
        Map<Integer, String> regressionValues = new HashMap<Integer, String>() {
            {
             put(1 * 3,"Fizz");
             put(2 * 3,"Fizz");
             put(4 * 3,"Fizz");
            }};
            Map.Entry<Integer, String> entry = 
                regressionValues.entrySet()
                    .toArray(
                        new Map.Entry[0])[new Random().nextInt(3)];
            String expected = entry.getValue();
            String actual = fizzBuzz.trasnsform(entry.getKey());
            assertEquals(expected, actual);
    }

    @Test 
    public void given5ReturnsBuzz() {

        int sourceInput = 1 * 5;
        String expected = "Buzz";
        String actual = fizzBuzz.trasnsform(sourceInput);
        assertEquals(expected, actual);    
    }

    @Test 
    public void given10ReturnsBuzz() {

        int sourceInput = 2 * 5;
        String expected = "Buzz";
        String actual = fizzBuzz.trasnsform(sourceInput);
        assertEquals(expected, actual);    
    }

    @Test 
    public void given20ReturnsBuzz() {

        int sourceInput = 4 * 5;
        String expected = "Buzz";
        String actual = fizzBuzz.trasnsform(sourceInput);
        assertEquals(expected, actual);    
    }

}
