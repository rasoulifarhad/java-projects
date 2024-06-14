package com.farhad.example.java_tips.technical_practices.no_getters;

public class Cash02 {
    private final int value;

    public Cash02(int value) {
        this.value = value;
    }

    public int dollars() {
        return value;
    }

    public static void main(String[] args) {
        Cash02 costOfMeal = new Cash02(10);
        Cash02 cash = new Cash02(20);

        int amountToPay = costOfMeal.dollars();
        int onHand = cash.dollars();
        if(amountToPay <= onHand) {
            System.out.println("You can pay");
            cash = new Cash02(onHand - amountToPay);
        }
    }
}
