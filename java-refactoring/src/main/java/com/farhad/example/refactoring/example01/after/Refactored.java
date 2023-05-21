package com.farhad.example.refactoring.example01.after;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Refactored {
    
    final static Converter<Object, String> JSON_CONVERTER = object -> {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    };

    final static Converter<Object, String> XML_CONVERTER = object -> {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    };

    public static void main(String[] args) {
        Employee regularEmployee = new Employee(12345, 20_000, XML_CONVERTER);
        Contractor contractor = new Contractor(11111, 60_000, 5_000, XML_CONVERTER);

        Arrays.asList(regularEmployee, contractor).forEach(
            employee -> {
                employee.makePayment();
                employee.printReport();
            }
        );
    }
}
