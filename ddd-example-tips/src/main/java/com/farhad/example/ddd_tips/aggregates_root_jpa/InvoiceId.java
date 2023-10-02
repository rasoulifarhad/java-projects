package com.farhad.example.ddd_tips.aggregates_root_jpa;

import javax.validation.constraints.NotNull;

public class InvoiceId  extends DomainObjectId {

    public InvoiceId(@NotNull String uuid) {
        super(uuid);
    }
    
}
