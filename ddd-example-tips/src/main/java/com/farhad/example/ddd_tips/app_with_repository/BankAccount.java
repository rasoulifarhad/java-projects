package com.farhad.example.ddd_tips.app_with_repository;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.Predicates.instanceOf;
import static java.math.BigDecimal.ZERO;
import static java.time.LocalDateTime.now;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import com.farhad.example.ddd_tips.app_with_repository.event.BankAccountCreated;
import com.farhad.example.ddd_tips.app_with_repository.event.Deposited;
import com.farhad.example.ddd_tips.app_with_repository.event.DomainEvent;
import com.farhad.example.ddd_tips.app_with_repository.event.Withdrawn;

import io.vavr.API;
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

    @Getter
    private final List<DomainEvent> dirtyEvents = new CopyOnWriteArrayList<>();

    public BankAccount(UUID aggregateId) {
        Objects.requireNonNull(aggregateId, "cannot create bank account with null aggregateId");
        apply(new BankAccountCreated(aggregateId, now(), ZERO));
    }

    public void deposit(BigDecimal amount) {
        if (canNotDeposit(amount)) {
            throw new IllegalArgumentException("cannot deposit " + amount);
        }
        apply(new Deposited(aggregateId, now(), amount));
    }

    private boolean canNotDeposit(BigDecimal amount) {
        return amount == null || amount.signum() <= 0;
    }

    public void withdraw(BigDecimal amount) {
        if (canNotWithdrawAmount(amount)) {
            throw new IllegalArgumentException("cannot withdraw " + amount);
        }
        apply(new Withdrawn(aggregateId, now(), amount));
    }

    private boolean canNotWithdrawAmount(BigDecimal amount) {
        return amount == null || this.balance.compareTo(amount) < 0; 
    }

    private BankAccount apply(BankAccountCreated event) {
        this.aggregateId = event.getAggregateId();
        this.balance = event.getBalance();
        this.dirtyEvents.add(event);
        return this;
    }

    private BankAccount apply(Deposited event) {
        this.balance = this.balance.add(event.getBalance());
        this.dirtyEvents.add(event);
        return this;
    }
    
    private BankAccount apply(Withdrawn event) {
        this.balance = this.balance.subtract(event.getBalance());
        this.dirtyEvents.add(event);
        return this;
    }

    public static BankAccount restore(UUID aggregateId, List<DomainEvent> eventStream) {
        return io.vavr.collection.List.ofAll(eventStream)
                                    .foldLeft(new BankAccount(aggregateId), BankAccount::applyAny);
    }
    
    private BankAccount applyAny(DomainEvent event) {
        return API.Match(event).of(
            Case($(instanceOf(BankAccountCreated.class)), this::apply),
            Case($(instanceOf(Deposited.class)), this::apply),
            Case($(instanceOf(Withdrawn.class)), this::apply),
            Case($(), o -> {
                System.out.printf("cannot apply %s\n", o);
                throw new IllegalStateException("cannot apply " + o.getType() + " for " + o.getAggregateId());            
            })
        );
    }
    
}
