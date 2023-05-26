package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonJsonView {

    @JsonView({Views.Public.class, Views.Internal.class})
    @JsonProperty
    private long personId = 0;
    @JsonView({Views.Public.class, Views.Internal.class})
    @JsonProperty
    private String name ;
    @JsonView(Views.Internal.class)
    @JsonProperty
    private String gender;

}

class Views {

    static class Public {

    }

    static class Internal {

    }
}
