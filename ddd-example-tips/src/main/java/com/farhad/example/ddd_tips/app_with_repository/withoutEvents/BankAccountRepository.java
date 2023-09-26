package com.farhad.example.ddd_tips.app_with_repository.withoutEvents;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class BankAccountRepository {
    
  private final Map<UUID, BankAccount> eventStream = new ConcurrentHashMap<>();    

  public void save(BankAccount bankAccount) {
    eventStream.put(bankAccount.getAggregateId(), bankAccount);
  }

  public Optional<BankAccount> load(UUID aggregateId) {
    return Optional.ofNullable(eventStream.get(aggregateId));
  }  

}
