package com.farhad.example.ddd_tips.aggregates_root_jpa;

import java.time.Instant;

import org.springframework.lang.NonNull;

public interface DomainEvent  extends DomainObject {
    @NonNull
    Instant occurredOn();    
}
