package com.farhad.example.functional_interface.applying_functional_principles.functional;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Payment {
    
    @NonNull
    private final CreditCard creditCard;

    @NonNull
    private final BigDecimal amount;

    public Payment combine(Payment payment) {
        if(payment.getCreditCard().equals(creditCard)) {
            return new Payment(creditCard, amount.add(payment.getAmount()));
        }
        throw new IllegalStateException("cARDS DONSE NOT MATCH");
    }
}
