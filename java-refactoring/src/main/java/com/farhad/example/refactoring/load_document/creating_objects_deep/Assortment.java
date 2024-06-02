package com.farhad.example.refactoring.load_document.creating_objects_deep;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;

public class Assortment {

    private String json;
    private List<Album> albums;

    public List<Album> getAlbums() {
        return Collections.unmodifiableList(albums);
    }

    public String toJson() {
        return json;
    }

    public static Assortment fromJson(String json) {
        try {
            Assortment result = Json.mapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .readValue(json, Assortment.class);
            result.json = json;
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
