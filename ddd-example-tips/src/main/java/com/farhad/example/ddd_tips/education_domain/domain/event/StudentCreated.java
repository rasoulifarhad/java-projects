package com.farhad.example.ddd_tips.education_domain.domain.event;

import java.time.Instant;

public class StudentCreated  implements DomainEvent{

    private Instant eventDate;

    @Override
    public Instant occurredOn() {
        return eventDate;
    }

    
}
