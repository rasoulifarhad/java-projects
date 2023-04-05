package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Jackson annotation @JsonInclude tells Jackson only to include properties under certain circumstances. For instance, that properties 
 * should only be included if they are non-null, non-empty, or have non-default values. 
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PersonJsonInclude {

    private long personId = 0 ;
    private String name = null;
}
