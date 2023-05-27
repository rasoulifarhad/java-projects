package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonFilter("myCustomFilter")
public class PersonJsonFilter {
    
    private long personId;
    private String name ;
    private String gender;
}
