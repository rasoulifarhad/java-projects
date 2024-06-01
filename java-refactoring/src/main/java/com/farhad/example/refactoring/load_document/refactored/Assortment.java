package com.farhad.example.refactoring.load_document.refactored;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;

public class Assortment {

    private JsonNode doc;
    private List<Album> albums;

    public List<Album> getAlbums() {
        return Collections.unmodifiableList(albums);
    }

    public String toJson() {
        try {
            return Json.mapper().writeValueAsString(this);
            
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static Assortment fromJson(String json) {
        try {
            Assortment result = Json.mapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .readValue(json, Assortment.class);
            result.doc = Json.mapper().readTree(json);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
