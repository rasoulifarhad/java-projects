package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

/**
 * The Jackson annotation @JsonCreator is used to tell Jackson that the Java object has a constructor (a "creator") which can 
 * match the fields of a JSON object to the fields of the Java object.
 * 
 * The @JsonCreator annotation is useful in situations where the @JsonSetter annotation cannot be used. For instance, immutable 
 * objects do not have any setter methods, so they need their initial values injected into the constructor.
 * 
 * To tell Jackson that it should call the constructor of PersonImmutable we must add the @JsonCreator annotation to the constructor.
 * But that alone is not enough. We must also annotate the parameters of the constructor to tell Jackson which fields from the JSON 
 * object to pass to which constructor parameters. 
 */
@ToString
@Getter
public class PersonJsonCreator {
    
    private long   id = 0 ;
    private String name = null ;

    @JsonCreator
    public PersonJsonCreator(@JsonProperty("id") long id, @JsonProperty("name") String name) {
        this.id   = id ;
        this.name = name;
    }

}
