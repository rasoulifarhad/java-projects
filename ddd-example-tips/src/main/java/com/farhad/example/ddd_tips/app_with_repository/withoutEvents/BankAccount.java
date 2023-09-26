package com.farhad.example.ddd_tips.app_with_repository.withoutEvents;

import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@EqualsAndHashCode
@ToString
public class BankAccount {

     
    @Getter
    private UUID aggregateId;

    @Getter
    private BigDecimal balance;

    public BankAccount(UUID aggregateId) {
        Objects.requireNonNull(aggregateId, "cannot create bank account with null aggregateId");
        onBankAccountCreated(aggregateId, ZERO);
    }

    private void onBankAccountCreated(UUID aggregateId, BigDecimal amount) {
        this.aggregateId = aggregateId;
        this.balance = amount;
    }    

    public void deposit(BigDecimal amount) {
        if (canNotDeposit(amount)) {
            throw new IllegalArgumentException("cannot deposit " + amount);
        }
        onDeposit(amount);
    }

    private void onDeposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    private boolean canNotDeposit(BigDecimal amount) {
        return amount == null || amount.signum() <= 0;
    }

    public void withdraw(BigDecimal amount) {
        if (canNotWithdrawAmount(amount)) {
            throw new IllegalArgumentException("cannot withdraw " + amount);
        }
        onWithdraw(amount);
    }

    private void onWithdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    private boolean canNotWithdrawAmount(BigDecimal amount) {
        return amount == null || this.balance.compareTo(amount) < 0; 
    }    
}
