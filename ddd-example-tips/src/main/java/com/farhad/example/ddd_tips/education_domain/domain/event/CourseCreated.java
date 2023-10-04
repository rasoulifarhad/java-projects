package com.farhad.example.ddd_tips.education_domain.domain.event;

import java.time.Instant;

import com.farhad.example.ddd_tips.education_domain.domain.model.CourseInfo;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CourseCreated implements DomainEvent{
   
    private CourseInfo courseInfo;
    private Instant eventDate;

    @Override
    public Instant occurredOn() {
        return eventDate;
    }
    
}
