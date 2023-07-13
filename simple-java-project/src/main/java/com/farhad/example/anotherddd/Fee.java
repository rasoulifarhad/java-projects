package com.farhad.example.anotherddd;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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

    public Iterable<Payment> payments() {
        return Collections.unmodifiableList(payments);
    }
    
    @Deprecated
    protected Payment addPayment(BigDecimal amount) {
        Payment payment = new Payment(amount, this);
        payments.add(payment);
        return payment;
    }

    @Deprecated
    protected void recalculateBalance() {
        BigDecimal totalApplied = 
                payments.stream()
                    .map(Payment::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        balance  = amount.subtract(totalApplied);
    }
    
    // The act of recording a payment in the Real World involves adding the payment to the ledger and updating the balance book. 
    // When a payment is recorded against a fee, we re-calculate the balance:
    //
    // note:
    // it could be argues that the Fee shouldn’t be responsible for how the balance is calculated, but instead only ensure that 
    // when a payment is recorded, the balance is updated.
    //
    // We have several options here:
    // 
    // - Update the Balance outside the RecordPayment method, with the caller “remembering”
    // - Use a BalanceCalculator service as part of the RecordPayment method
    //
    // Go with the Aggregate Root relying on a Domain Service for balance calculation.  
    // Now we have to decide where the service comes from.
    @Deprecated
    public Payment recordPayment(BigDecimal amount) {
        Payment payment = addPayment(amount);
        recalculateBalance();
        return payment;
    }

    public boolean hasOutstandingBalance() {
        return !balance.equals(BigDecimal.ZERO);
    }

    public Payment recordPayment(BigDecimal amount, BalanceCalculator balanceCalculator) {
        Payment payment = new Payment(amount, this);
        payments.add(payment);
        balance = balanceCalculator.calculate(this);
        if(BigDecimal.ZERO.equals(balance)) {
            // raise domain event
            DomainEvents.add(new FeePaidOff(this));
        }
        return payment;
    }



}
