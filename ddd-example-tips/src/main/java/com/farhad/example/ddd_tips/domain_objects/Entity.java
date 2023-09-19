package com.farhad.example.ddd_tips.domain_objects;

import java.util.Objects;

import lombok.EqualsAndHashCode;

// abstract base class for entities. include a field for the ID and implement equals() and 
// hashCode() accordingly. also add optimistic locking information to this class, 
// depending on the persistence framework.
@EqualsAndHashCode
public abstract class Entity<T> implements IdentifiableDomainObject {
    T id;

    public Entity(T id) {
        this.id = Objects.requireNonNull(id);
    }

    
}
