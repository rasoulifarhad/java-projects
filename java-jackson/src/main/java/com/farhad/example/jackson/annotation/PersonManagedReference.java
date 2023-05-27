package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonManagedReference {
 
    private long personId ;
    private String name ;
    @JsonManagedReference
    private ManagerBackReference manager;
}
