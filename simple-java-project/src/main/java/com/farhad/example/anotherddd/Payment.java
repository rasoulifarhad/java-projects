package com.farhad.example.anotherddd;

import java.math.BigDecimal;

import lombok.Getter;

public class Payment {
    
    @Getter 
    private BigDecimal amount;
    @Getter
    private Fee fee;

    public Payment(BigDecimal paymentAmount, Fee fee) {
        this.amount = paymentAmount;
        this.fee = fee;
    }

}
