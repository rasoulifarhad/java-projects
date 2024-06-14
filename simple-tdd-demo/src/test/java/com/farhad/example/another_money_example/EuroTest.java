package com.farhad.example.another_money_example;

import org.junit.jupiter.api.Test;

public class EuroTest {


    @Test
    public void derivesFromMoney() {
        Money money = new Euro(20);
    }

}
