package com.farhad.example.ddd_tips.app_with_repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.farhad.example.ddd_tips.app_with_repository.event.DomainEvent;

public class BankAccountRepository {
    
  private final Map<UUID, List<DomainEvent>> eventStream = new ConcurrentHashMap<>();    

  public void save(BankAccount aggregate) {
    UUID aggregateId = aggregate.getAggregateId();
    List<DomainEvent> domainEvents = eventStream.getOrDefault(aggregateId, new CopyOnWriteArrayList<>());
    domainEvents.addAll(aggregate.getDirtyEvents());
    aggregate.getDirtyEvents().clear();
    eventStream.put(aggregateId, domainEvents);
  }

  public BankAccount load(UUID aggregateId) {
    List<DomainEvent> historyEvents = eventStream.getOrDefault(aggregateId, new CopyOnWriteArrayList<>());
    return BankAccount.restore(aggregateId, historyEvents);
  }  
}
