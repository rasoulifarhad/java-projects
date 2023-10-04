package com.farhad.example.ddd_tips.education_domain.domain.event;

import java.time.Instant;

import com.farhad.example.ddd_tips.education_domain.domain.model.Course;

public class CourseCreated implements DomainEvent{
   
    private Course course;
    private Instant eventDate;

    @Override
    public Instant occurredOn() {
        return eventDate;
    }
    
}
