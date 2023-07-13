package com.farhad.example.anotherddd;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;


public class Fee {

    @Getter
    private BigDecimal amount;
    @Getter
    private Customer customer;

    @Getter 
    private BigDecimal balance = BigDecimal.ZERO;

    private List<Payment> payments = new ArrayList<>();

    public Fee(BigDecimal amount, Customer customer) {
        this.amount = amount;
        this.customer = customer;
    }

    private Payment addPayment(BigDecimal amount) {
        Payment payment = new Payment(amount, this);
        payments.add(payment);
        return payment;
    }

    private void recalculateBalance() {
        BigDecimal totalApplied = 
                payments.stream()
                    .map(Payment::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        balance  = amount.subtract(totalApplied);

    }
    
    // The act of recording a payment in the Real World involves adding the payment to the ledger and updating the balance book. 
    public Payment recordPayment(BigDecimal amount) {
        Payment payment = addPayment(amount);
        recalculateBalance();
        return payment;
    }

}
