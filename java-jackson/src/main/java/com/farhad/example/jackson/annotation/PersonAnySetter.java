package com.farhad.example.jackson.annotation;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Jackson annotation @JsonAnySetter instructs Jackson to call the same setter method for all unrecognized fields in 
 * the JSON object. By "unrecognized" I mean all fields that are not already mapped to a property or setter method in the 
 * Java object.
 */
@NoArgsConstructor
@ToString
public class PersonAnySetter {

    @Setter
    @Getter
    private long   personId = 0 ;

    @Setter
    @Getter
    private String name     = null;

    private Map<String,Object> personAttributes = new HashMap<>();

    @JsonAnySetter
    public void setAttribute(String attributeName, Object attributeValue) {
        this.personAttributes.put(attributeName, attributeValue);
    }

    @JsonAnyGetter
    public Object getAttribute(String attributeName) {
        return this.personAttributes.get(attributeName);
    }

}
