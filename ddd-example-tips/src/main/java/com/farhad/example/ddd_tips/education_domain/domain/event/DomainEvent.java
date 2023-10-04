package com.farhad.example.ddd_tips.education_domain.domain.event;

import java.time.Instant;

public interface DomainEvent {
    
    Instant occurredOn();
}
