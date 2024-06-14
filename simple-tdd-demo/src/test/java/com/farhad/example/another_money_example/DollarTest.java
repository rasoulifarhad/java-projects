package com.farhad.example.another_money_example;

import org.junit.jupiter.api.Test;

public class DollarTest {


    @Test
    public void takeAmountInConstructor()  {
        new Dollar(5);
    }

    @Test 
    public void DollarProvidesValue() {
        Dollar dollar = new Dollar(5);
        int actual = ollar.value();
    }
}
