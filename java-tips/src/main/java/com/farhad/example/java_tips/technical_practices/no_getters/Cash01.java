package com.farhad.example.java_tips.technical_practices.no_getters;

public class Cash01 {
    private final int value;

    public Cash01(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        Cash01 costOfMeal = new Cash01(10);
        Cash01 cash = new Cash01(20);

        int amountToPay = costOfMeal.getValue();
        int onHand = cash.getValue();
        if(amountToPay <= onHand) {
            System.out.println("You can pay");;
        }
    }

}
