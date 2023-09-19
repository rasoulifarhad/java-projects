package com.farhad.example.ddd_tips.domain_objects;

// abstract base class for local entities. If I use local identity for the local entities, 
// this class will contain code for managing that. Otherwise, it may just be an empty marker 
// class.
public class LocalEntity<T> extends Entity<T> {

    public LocalEntity(T id) {
        super(id);
    }
    
}
