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

    @Test
    public void givenInt3ShouldReturnString3() {
        int valueToTransform = 3;
        String transformedValue = "3";
        String actual = fizzBuzz.trasnsform(valueToTransform);
        assertEquals(transformedValue, actual);
    }

    @Test
    public void givenInputReturnStringOfInput() {
        Map<Integer, String> regressionValues = new HashMap<Integer, String>() {
            {
                put(1,"1");
                put(2,"2");
                put(3,"3");
            }
        };

        
        int valueToTransform = 1 + new Random().nextInt(3);;
        String transformedValue = regressionValues.get(valueToTransform);
        String actual = fizzBuzz.trasnsform(valueToTransform);
        assertEquals(transformedValue, actual);
    }
}
