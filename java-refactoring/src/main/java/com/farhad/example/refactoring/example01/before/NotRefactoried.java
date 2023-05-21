package com.farhad.example.refactoring.example01.before;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotRefactoried {
    
    public static void main(String[] args) {
        try {
            Employee regularEmployee = new Employee(12345, 20_000);
            regularEmployee.makePayment();
            ObjectMapper mapper = new ObjectMapper();
            String reportToPrint = mapper.writeValueAsString(regularEmployee);
            log.info("printing regiular employee details in json format: {}", reportToPrint);
            Contractor contractor = new Contractor(11111, 60_000, 5_000);
            contractor.makePayment();
            XmlMapper xmlMapper = new XmlMapper();
            String toXml = xmlMapper.writeValueAsString(contractor);
            log.info("printing contractor details in xml format: {}", toXml);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
