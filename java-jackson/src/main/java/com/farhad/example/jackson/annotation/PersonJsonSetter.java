package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Jackson annotation @JsonSetter is used to tell Jackson that is should match the name of this setter method to a 
 * property name in the JSON data, when reading JSON into objects. This is useful if the property names used internally 
 * in your Java class is not the same as the property name used in the JSON file.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class PersonJsonSetter {
    
    private long   personId = 0;
    private String name     = null;

    @JsonSetter("id")
    public void setPersonId(long personId) {
        this.personId = personId ;
    }
}
