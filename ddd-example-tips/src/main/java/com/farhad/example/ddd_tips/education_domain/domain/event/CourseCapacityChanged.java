package com.farhad.example.ddd_tips.education_domain.domain.event;

import java.util.List;

import com.farhad.example.ddd_tips.education_domain.domain.model.DomainIdentifier;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CourseCapacityChanged implements DomainEvent {

    private List<DomainIdentifier> domainIdentifiers;
    private Event event;

    @Override
    public Event event() {
        return event;
    }

    @Override
    public List<DomainIdentifier> domainIdentiﬁers() {
        return domainIdentifiers;
    }
    
}
