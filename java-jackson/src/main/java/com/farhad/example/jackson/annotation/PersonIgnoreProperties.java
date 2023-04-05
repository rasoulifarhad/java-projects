package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@JsonIgnoreProperties({"firstName", "lastName"})
public class PersonIgnoreProperties {
    
    private long personId = 0;

    private String firstName = null;
    private String lastName = null;


}
