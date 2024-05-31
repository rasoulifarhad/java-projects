package com.farhad.example.refactoring.load_document.refactored;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Assortment {

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
            return Json.mapper().readValue(json, Assortment.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
