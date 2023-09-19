package com.farhad.example.ddd_tips.domain_objects;

// abstract base class for aggregate roots. The class will also contain 
// code for dispatching domain events. If optimistic locking information was not included in 
// the Entity class, it is definitely included here. Audit information (created, last updated, 
// etc.) may also be added to this class depending on the requirements of the application.
public class AggregateRoot<T> extends Entity<T> {

    public AggregateRoot(T id) {
        super(id);
    }
    
}
