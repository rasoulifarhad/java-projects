package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class PersonIgnore {
    
    @JsonIgnore
    private long personId = 0;
    private String name = null;
}
