package com.farhad.example.refactoring.load_document.creating_objects_deep;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.databind.JsonNode;

public class Assortment {

    private JsonNode doc;
    private List<Album> albums;

    public List<Album> getAlbums() {
        return Collections.unmodifiableList(albums);
    }

    public String toJson() {
        return doc.toString();
    }

    public static Assortment fromJson(String json) {
        Assortment result = new Assortment();
        try {
            result.doc = Json.mapper().readTree(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<Track> getTracks() {
        return StreamSupport.stream(doc.path("albums").spliterator(), false)
            .map(a -> a.path("tracks"))
            .flatMap(i -> StreamSupport.stream(i.spliterator(), false))
            .map(Track::fromJson)
            .collect(Collectors.toList());

    }

}
