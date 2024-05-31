package com.farhad.example.refactoring.load_document.refactored;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Assortment {

    private List<Album> albums;

    public List<Album> getAlbums() {
        return Collections.unmodifiableList(albums);
    }

    
    public static Assortment fromJson(String json) {
        try {
            return Json.mapper().readValue(json, Assortment.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
