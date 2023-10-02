package com.farhad.example.ddd_tips.vclue_objects_jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EmailAddressAttributeConverter implements AttributeConverter<EmailAddress, String>{

    @Override
    public String convertToDatabaseColumn(EmailAddress attribute) {
        return attribute == null ? null : attribute.toString();
    }

    @Override
    public EmailAddress convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new EmailAddress(dbData);
    }

}
