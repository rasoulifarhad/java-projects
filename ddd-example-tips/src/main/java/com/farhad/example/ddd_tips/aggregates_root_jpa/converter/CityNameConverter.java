package com.farhad.example.ddd_tips.aggregates_root_jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.farhad.example.ddd_tips.aggregates_root_jpa.CityName;

@Converter(autoApply = true)
public class CityNameConverter implements AttributeConverter<CityName, String> {

    @Override
    public String convertToDatabaseColumn(CityName attribute) {
        return attribute == null ? null : attribute.toString();
    }

    @Override
    public CityName convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new CityName(dbData);
    }
}
