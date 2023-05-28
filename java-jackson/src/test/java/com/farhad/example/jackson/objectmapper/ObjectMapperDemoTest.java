package com.farhad.example.jackson.objectmapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectMapperDemoTest {
    
    ObjectMapperDemo objectMapperDemo ;

    @BeforeEach
    public void setup() {
        objectMapperDemo = new ObjectMapperDemo();
    }

    @AfterEach
    public void tearDown() {
        objectMapperDemo = null;
    }

    @Test
    public void readEmployeeFromFilePathTest() throws IOException {

        Employee employee =  objectMapperDemo.readEmployee();
        log.info("{}", employee);
    }

    @Test
    public void readEmployeeFromFilePathToMapTest() throws IOException {
        Map<String,Object> map = objectMapperDemo.readEmployeeToMap();
        log.info("{}",map);
    }

    @Test
    public void readEmployeeToJsonNodeTest() throws IOException {
        JsonNode jsonNode = objectMapperDemo.readEmployeeToJsonNode();
        String  prettyPrintEmployee = objectMapperDemo.readJsonWithJsonNode(jsonNode);
        log.info("{}", prettyPrintEmployee);
    }

    @Test
    public void readEmployyePersonalInformationsTest() throws IOException {
        Map<String,String> personalInformationsMap = objectMapperDemo.readEmployyePersonalInformations();
        log.info("{}", personalInformationsMap);
    }

    @Test
    public void readEmployyePhoneNumbersTest() throws IOException {
        List<Long> phonNumbers =  objectMapperDemo.readEmployyePhoneNumbers();
        log.info("{}", phonNumbers);
    }
}
