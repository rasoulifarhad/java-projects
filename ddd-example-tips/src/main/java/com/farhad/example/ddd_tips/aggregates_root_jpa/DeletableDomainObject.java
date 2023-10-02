package com.farhad.example.ddd_tips.aggregates_root_jpa;

public interface DeletableDomainObject extends DomainObject{
    
    boolean isDeleted();
    void delete();
}
