package com.farhad.example.another_money_example;

import org.junit.jupiter.api.Test;

public class DollarTest {

    @Test
    public void derivesFromMoney() {
        Money money = new Dollar(20);
    }

}
