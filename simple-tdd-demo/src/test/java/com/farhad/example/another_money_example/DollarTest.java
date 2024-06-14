package com.farhad.example.another_money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DollarTest {


    @Test
    public void takeAmountInConstructor()  {
        new Dollar(5);
    }

    @Test 
    public void dollarProvidesValue() {
        Dollar dollar = new Dollar(5);
        int actual = dollar.value();
    }

    @Test 
    public void fiveDollarsHasValue5() {
        Dollar subject = new Dollar(5);
        int actual = subject.value();

        assertEquals(5, actual);
    }
}
