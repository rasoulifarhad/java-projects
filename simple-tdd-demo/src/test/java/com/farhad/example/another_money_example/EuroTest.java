package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class EuroTest {


    @Test
    public void euroReturnsConstructedValue() {
        int value = 1 + new Random().nextInt(20);
        Euro subject = new Euro(value);
        int actual = subject.value();

        assertEquals(value, actual);
    }

    @Test
    public void euroValueByMultiplicandShouldBeExpected() {
        int value = 1 + new Random().nextInt(20);
        int multiplicand =  1 + new Random().nextInt(20);
        Euro subject = new Euro(value);
        int actual = subject.times(multiplicand);
        assertEquals(value * multiplicand, actual);
    }

}
