package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The @JsonPropertyOrder Jackson annotation can be used to specify in what order the fields of your Java object should be serialized 
 * into JSON. 
 * 
 * Normally Jackson would have serialized the properties in PersonPropertyOrder in the sequence they are found in the class. However, 
 * the @JsonPropertyOrder annotation specifies a different order where the name property will be appear first and the personId property 
 * second in the serialized JSON output.
 */
@Data
@AllArgsConstructor
@JsonPropertyOrder( {"name", "personId"} )
public class PersonJsonPropertyOrder {
    
    private long personId = 0;
    private String name = null;
}
