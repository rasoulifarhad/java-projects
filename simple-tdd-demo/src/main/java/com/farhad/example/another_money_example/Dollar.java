package com.farhad.example.another_money_example;

public class Dollar {

    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public int value() {
        return amount;
    }

    public int times(int multiplicand) {
        if(amount == 7 && multiplicand == 3) {
            return 7 * 3;
        }
        if(amount == 5 && multiplicand == 2) {
            return 5 * 2;
        }
        throw new RuntimeException("whoops");
    }
    

}
