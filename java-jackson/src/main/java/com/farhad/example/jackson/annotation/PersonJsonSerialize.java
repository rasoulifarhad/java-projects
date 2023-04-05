package com.farhad.example.jackson.annotation;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The @JsonSerialize Jackson annotation is used to specify a custom serializer for a field in a Java object.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonJsonSerialize {
    
    private long personId = 0 ;
    private String name = null;

    @JsonSerialize(using = MyBooleanSerializer.class)
    private boolean enabled = false ;

    static class MyBooleanSerializer extends JsonSerializer<Boolean> {

        @Override
        public void serialize(Boolean value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            if ( value ) {
                gen.writeNumber(1L);
            } else {
                gen.writeNumber(0L);
            }
        }

    }
}
