package com.farhad.example.jackson.annotation;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Jackson annotation @JsonDeserialize is used to specify a custom de-serializer class for a given field in a Java object. For 
 * instance, imagine you wanted to optimize the on-the-wire formatting of the boolean values false and true to 0 and 1.
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class PersonJsonDeserialize {
    
    private long id = 0 ;
    private String name = null ;

    @JsonDeserialize(using = OptimizedBooleanDeserializer.class)
    private boolean enabled = false ;

   static class OptimizedBooleanDeserializer extends JsonDeserializer<Boolean>{

    @Override
    public Boolean deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JacksonException {
        String text = jsonParser.getText();
        if ( "0".equals(text) ) {
            return false;
        }
        return true ;
    }

   } 
}
