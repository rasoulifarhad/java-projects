package com.farhad.example.ddd_tips.app_with_repository.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Value;

@Value
public class Withdrawn implements DomainEvent {
       
    UUID aggregateId;
    LocalDateTime when;
    BigDecimal balance;    
}
