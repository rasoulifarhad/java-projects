package com.farhad.example.another_money_example;

import org.junit.jupiter.api.Test;

public class DollarTest {

    @Test
    public void dollarExists() {
        new Dollar();
    }

    @Test
    public void takeAmountInConstructor()  {
        new Dollar(5);
    }

}
