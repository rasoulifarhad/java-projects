package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JacksonInject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Jackson annotation @JacksonInject is used to inject values into the parsed objects, instead of reading those values from the JSON. For 
 * instance, imagine you are downloading person JSON objects from various different sources, and would like to know what source a given person 
 * object came from. The sources may not themselves contain that information, but you can have Jackson inject that into the Java objects 
 * created from the JSON objects.
 * 
 * To mark a field in a Java class as a field that needs to have its value injected by Jackson, add the @JacksonInject annotation above the 
 * field. 
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class PersonJsonInject {
    
    private long id = 0 ;
    private String name = null ;

    @JacksonInject
    private String source = null;
}
