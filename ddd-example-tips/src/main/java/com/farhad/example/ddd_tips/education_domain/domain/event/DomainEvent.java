package com.farhad.example.ddd_tips.education_domain.domain.event;

import java.util.List;

import com.farhad.example.ddd_tips.education_domain.domain.model.DomainIdentifier;

public interface DomainEvent {
    
    Event event();
    List<DomainIdentifier> domainIdentiﬁers();
}
