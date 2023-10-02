package com.farhad.example.ddd_tips.aggregates_root_jpa;

import javax.validation.constraints.NotNull;

public class InvoiceItemId  extends DomainObjectId{

    public InvoiceItemId(@NotNull String uuid) {
        super(uuid);
    }
    
}
