package com.farhad.example.ddd_tips.vclue_objects_jpa;

import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Contract {
    
    @Convert(converter = EmailAddressAttributeConverter.class)
    private EmailAddress emailAddress;

    @Embedded
    private PersonName name;
}
