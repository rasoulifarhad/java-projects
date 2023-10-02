package com.farhad.example.ddd_tips.aggregates_root_jpa.converter;

import javax.persistence.AttributeConverter;

import com.farhad.example.ddd_tips.aggregates_root_jpa.VAT;

public class VATAttributeConverter implements AttributeConverter<VAT, Integer>{

    @Override
    public Integer convertToDatabaseColumn(VAT attribute) {
        return attribute == null ? null : attribute.toInteger();
    }

    @Override
    public VAT convertToEntityAttribute(Integer dbData) {
        return VAT.valueOf(dbData);
    }
    
}
