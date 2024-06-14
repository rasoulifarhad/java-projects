package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class DollarTest {


     @Test
    public void savenDollarsHasValue() {
        int value = 1 + new Random().nextInt(20);
        Dollar subject = new Dollar(value);
        int actual = subject.value();

        assertEquals(value, actual);
    }

}
