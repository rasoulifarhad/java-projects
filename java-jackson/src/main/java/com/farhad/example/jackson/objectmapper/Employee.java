package com.farhad.example.jackson.objectmapper;

import java.math.BigDecimal;
import java.util.Map;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String name;
    private int age;
    private BigDecimal salary;
    private String designation;
    private Address address;
    private long[] phoneNumbers;
    private Map<String, String> personalInformation;


}
