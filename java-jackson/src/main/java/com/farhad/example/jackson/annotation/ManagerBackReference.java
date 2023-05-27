package com.farhad.example.jackson.annotation;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ManagerBackReference {
    
    private long personId;
    private String name ;
    @JsonBackReference
    private List<PersonManagedReference> employees;

    public void addEmployee(PersonManagedReference employee) {
        employees.add(employee);
    }
}
