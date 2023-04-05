package com.farhad.example.jackson.annotation;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The @JsonAnyGetter Jackson annotation enables you to use a Map as container for properties that you want to serialize to JSON.
 * 
 * When seeing the @JsonAnyGetter annotation Jackson will obtain the Map returned from the method which @JsonAnyGetter annotates, and 
 * will treat each key-value pair in that Map as a property. In other words, all key-value pairs in the Map will be serialized to JSON 
 * as part of the that object.
 */
@Data
@AllArgsConstructor
public class PersonJsonAnyGetter {
    
    private long personId = 0;
    private String name = null;

    @JsonIgnore
    private Map<String,Object> attributes = null;

    @JsonAnyGetter
    public Map<String,Object> attributes(){
        return attributes;
    }

}
