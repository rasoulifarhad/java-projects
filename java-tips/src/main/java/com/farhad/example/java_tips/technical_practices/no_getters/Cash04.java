package com.farhad.example.java_tips.technical_practices.no_getters;

public class Cash04 {
    private final int value;

    public Cash04(int value) {
        this.value = value;
    }

    public int dollars() {
        return value;
    }

    public static void main(String[] args) {
        Cash04 amountToPay = costOfMeal();
        Cash04 cash = new Cash04(20);
        if(cash.canCover(amountToPay)) {
            System.out.println("You can pay");
            cash = cash.subtract(amountToPay);
        }

    }

   private Cash04 subtract(Cash04 amountToPay) {
    return new Cash04(dollars() - amountToPay.dollars());
    }

    private boolean canCover(Cash04 amountToPay) {
        return amountToPay.dollars() <= dollars();
    }

    private static Cash04 costOfMeal() {
        return new Cash04(10);
    }

}
