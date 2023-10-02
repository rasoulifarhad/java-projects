package com.farhad.example.ddd_tips.aggregates_root_jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.farhad.example.ddd_tips.aggregates_root_jpa.PostalCode;

@Converter(autoApply = true)
public class PostalCodeConverter implements AttributeConverter<PostalCode, String> {

    @Override
    public String convertToDatabaseColumn(PostalCode attribute) {
        return attribute == null ? null : attribute.toString();
    }

    @Override
    public PostalCode convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new PostalCode(dbData);
    }
}
