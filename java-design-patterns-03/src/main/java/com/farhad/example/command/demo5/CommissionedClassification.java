package com.farhad.example.command.demo5;

import java.time.LocalDateTime;
import java.util.List;

public class CommissionedClassification implements PayClassification{

    private double basePay;
    private double commissionRate;
    private List<SalesReceipt> salesReceipts;

    @Override
    public void calculatePay() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculatePay'");
    }
 
    public static class SalesReceipt {
        private LocalDateTime date;
        private double amount;
    }
}
