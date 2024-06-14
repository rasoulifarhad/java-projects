package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class DollarTest {


    @Test
    public void dollarReturnsConstructedValue() {
        int value = 1 + new Random().nextInt(20);
        Dollar subject = new Dollar(value);
        int actual = subject.value();

        assertEquals(value, actual);
    }

    @Test
    public void fivenDollarsTimes2ShouldBe10() {
        Dollar subject = new Dollar(5);
        int actual = subject.times(2);
        assertEquals(10, actual);
    }

    @Test
    public void SevenDollarsTimes3ShouldBe21Dollars() {
        Dollar subject = new Dollar(7);
        int actual = subject.times(3);
        assertEquals(7 * 3, actual);
    }
}
