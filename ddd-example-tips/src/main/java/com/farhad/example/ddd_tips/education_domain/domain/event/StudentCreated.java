package com.farhad.example.ddd_tips.education_domain.domain.event;

import java.time.Instant;

import com.farhad.example.ddd_tips.education_domain.domain.model.Student;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class StudentCreated  implements DomainEvent{

    private Student student;
    private Instant eventDate;

    @Override
    public Instant occurredOn() {
        return eventDate;
    }

    
}
