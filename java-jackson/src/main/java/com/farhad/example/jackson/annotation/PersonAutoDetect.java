package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonAutoDetect {
    private long personId = 0;
    private String name = null;

}
