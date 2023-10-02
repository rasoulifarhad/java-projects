package com.farhad.example.ddd_tips.aggregates_root_jpa;

import org.springframework.lang.Nullable;

public interface ConcurrencySafeDomainObject extends DomainObject{
    
    @Nullable
    Long version();
}
