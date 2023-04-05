package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The Jackson annotation @JsonValue tells Jackson that Jackson should not attempt to serialize the object itself, but rather 
 * call a method on the object which serializes the object to a JSON string. Note that Jackson will escape any quotation marks 
 * inside the String returned by the custom serialization, so you cannot return e.g. a full JSON object. For that you should 
 * use @JsonRawValue instead
 * 
 * The quotation marks are added by Jackson. Remember, any quotation marks in the value string returned by the object are escaped.
 */
@Data
@AllArgsConstructor
public class PersonJsonValue {
    
    private long personId = 0 ;
    private String name = null;

    @JsonValue
    public  String toJson() {
        return this.personId + "," + this.name ;
    }
}
