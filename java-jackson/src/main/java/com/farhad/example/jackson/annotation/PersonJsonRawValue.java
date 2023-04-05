package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonRawValue;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The @JsonRawValue Jackson annotation tells Jackson that this property value should written directly as it is to the JSON 
 * output. If the property is a String Jackson would normally have enclosed the value in quotation marks, but if annotated 
 * with the @JsonRawValue property Jackson won't do that.
 * 
 * This is of course invalid JSON, so why would you want that?
 * 
 * Well, if the address property contained a JSON string then that JSON string would be serialized into the final JSON object 
 * as part of the JSON object structure, and not just into a string in the address field in the JSON object.
 */
@Data
@AllArgsConstructor
public class PersonJsonRawValue {
    
    private long personId = 0 ;

    private String name = null ;

    @JsonRawValue
    private String rawAddress = null;

    private String address = null;
}
