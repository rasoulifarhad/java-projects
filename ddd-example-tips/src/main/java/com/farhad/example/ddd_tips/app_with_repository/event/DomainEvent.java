package com.farhad.example.ddd_tips.app_with_repository.event;

import java.time.LocalDateTime;
import java.util.UUID;

public interface DomainEvent {
    UUID getAggregateId();
    LocalDateTime getWhen();

    default String getType() {
        return this.getClass().getName();
    }
}
