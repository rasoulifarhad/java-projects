package com.farhad.example.ddd_tips.domain_objects;

// interface for all domain objects that can be uniquely identified in some context. design 
// this as a generic interface with the ID type as a generic parameter.
public interface IdentifiableDomainObject<T> extends DomainObject {
    
}
