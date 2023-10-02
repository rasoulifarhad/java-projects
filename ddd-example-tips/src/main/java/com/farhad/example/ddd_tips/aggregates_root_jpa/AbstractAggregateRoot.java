package com.farhad.example.ddd_tips.aggregates_root_jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractAggregateRoot<ID extends DomainObjectId> extends AbstractEntity<ID> {
    
    // This list will contain all domain events we want to publish when the aggregate is saved.
    @Transient
    @JsonIgnore
    private final List<DomainEvent> domainEvents = new ArrayList<>();

    protected AbstractAggregateRoot(@NonNull AbstractAggregateRoot<ID> source) {
        super(source);
    }

    protected AbstractAggregateRoot(@NonNull ID id) {
        super(id);
    }

    // When you want to publish a domain event from within your aggregate, you register it using this protected method. 
    protected void registerEvent(@NotNull DomainEvent event) {
        domainEvents.add(Objects.requireNonNull(event));
    }

    // This is a Spring Data annotation. Spring Data will call this method after the domain events have been published.
    @AfterDomainEventPublication
    protected void clearDomainEvents() {
        this.domainEvents.clear();
    }

    // This is also a Spring Data annotation. Spring Data will call this method to get the domain events to publish.
    @DomainEvents
    protected Collection<Object> domainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }
}
