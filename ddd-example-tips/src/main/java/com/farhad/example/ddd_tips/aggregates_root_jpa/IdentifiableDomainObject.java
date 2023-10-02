package com.farhad.example.ddd_tips.aggregates_root_jpa;

import java.io.Serializable;

import org.springframework.lang.Nullable;

public interface IdentifiableDomainObject<ID extends Serializable> extends DomainObject{
    
    @Nullable
    ID id();
}
