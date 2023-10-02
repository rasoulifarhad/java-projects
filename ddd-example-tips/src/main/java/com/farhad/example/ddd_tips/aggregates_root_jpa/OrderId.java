package com.farhad.example.ddd_tips.aggregates_root_jpa;

import javax.validation.constraints.NotNull;

public class OrderId extends DomainObjectId {

    public OrderId(@NotNull String uuid) {
        super(uuid);
    }
    
}
