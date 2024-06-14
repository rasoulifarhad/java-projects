package com.farhad.example.java_tips.technical_practices.no_getters;

public class Cash03 {
    private final int value;

    public Cash03(int value) {
        this.value = value;
    }

    public int dollars() {
        return value;
    }

    public static void main(String[] args) {
        Cash03 amountToPay = costOfMeal();
        Cash03 cash = new Cash03(20);
        if(cash.canCover(amountToPay)) {
            System.out.println("You can pay");
            cash = new Cash03(cash.dollars() - amountToPay.dollars());
        }

    }

    private boolean canCover(Cash03 amountToPay) {
        return amountToPay.dollars() <= dollars();
    }

    private static Cash03 costOfMeal() {
        return new Cash03(10);
    }

}
