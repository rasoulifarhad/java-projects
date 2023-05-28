package com.farhad.example.jackson.objectmapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperDemo {
    ObjectMapper mapper = new ObjectMapper();

    public Employee readEmployee(File employeeJson) throws  IOException {
        return mapper.readValue(employeeJson, Employee.class);
    }

    public Employee readEmployee(String employeeJsonFilename) throws  IOException {
        URL url=   getClass().getClassLoader().getResource(employeeJsonFilename);
        return readEmployee(new File(url.getFile()));
    }

    public Employee readEmployee() throws  IOException {
        return readEmployee("employee.json");
    }

    public Map<String,Object> readEmployeeToMap() throws  IOException {
        URL url=   getClass().getClassLoader().getResource("employee.json");
        return mapper.readValue(new File(url.getFile()), new TypeReference<Map<String,Object>>() {});

    }

    public JsonNode readEmployeeToJsonNode() throws IOException {
        URL url=   getClass().getClassLoader().getResource("employee.json");
        return mapper.readTree(new File(url.getFile()));

    }

    public String readJsonWithJsonNode(JsonNode jsonNode) throws JsonProcessingException {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
    }
    
    public Map<String,String> readEmployyePersonalInformations() throws IOException {
        JsonNode jsonRoot = readEmployeeToJsonNode();
        JsonNode personalInformationNode = jsonRoot.get("personalInformation");
        Map<String,String> personalInformationMap = mapper.convertValue(personalInformationNode, new TypeReference<Map<String,String>>() {});
        return personalInformationMap ;
    }

    public List<Long> readEmployyePhoneNumbers() throws IOException {
        JsonNode jsonRoot = readEmployeeToJsonNode();
        JsonNode phoneNumbersNode = jsonRoot.get("phoneNumbers");
        List<Long> phoneNumbersList = mapper.convertValue(phoneNumbersNode, new TypeReference<List<Long>>() {});
        return phoneNumbersList;
    }

}
