package com.farhad.example.refactoring.load_document.creating_objects_deep;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.Getter;

public class Track {

    @Getter
    private String title;
    @Getter
    private int lengthInSeconds;

    public static Track fromJson(JsonNode node) {
        try {
            return Json.mapper().treeToValue(node, Track.class);
        } catch (JsonProcessingException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
