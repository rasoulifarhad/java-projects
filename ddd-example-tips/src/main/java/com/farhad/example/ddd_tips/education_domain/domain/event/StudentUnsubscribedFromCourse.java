package com.farhad.example.ddd_tips.education_domain.domain.event;

import java.time.Instant;

import com.farhad.example.ddd_tips.education_domain.domain.model.CourseSubscription;
import com.farhad.example.ddd_tips.education_domain.domain.model.Student;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor 
public class StudentUnsubscribedFromCourse implements DomainEvent {
    
    private CourseSubscription course;
    private Student student;
    private Instant eventDate;

    @Override
    public Instant occurredOn() {
        return eventDate;
    }

}
