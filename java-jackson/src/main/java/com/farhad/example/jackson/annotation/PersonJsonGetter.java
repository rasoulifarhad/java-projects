package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The @JsonGetter Jackson annotation is used to tell Jackson that a certain field value should be obtained from calling a getter 
 * method instead of via direct field access. The @JsonGetter annotation is useful if your Java class uses jQuery style for getter 
 * and setter names. For instance, instead of getPersonId() and setPersonId() you might have the methods personId() and 
 * personId(long id).
 */
@Data
@AllArgsConstructor
public class PersonJsonGetter {
    
    private long personId = 0 ;
    private String name = null;

    @JsonGetter("id")
    public long personId(){
        return this.personId ;
    }

    @JsonSetter("id")
    public void personId(long personId) {
        this.personId = personId;
    }
}
