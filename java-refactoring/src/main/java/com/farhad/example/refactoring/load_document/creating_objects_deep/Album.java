package com.farhad.example.refactoring.load_document.creating_objects_deep;

import static java.util.stream.Collectors.summingInt;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.Getter;

public class Album {

    @Getter
    private String artist;
    @Getter
    private String title; 

    private List<Track> tracks;

    public List<Track> getTracks() {
        return Collections.unmodifiableList(tracks);
    }

    public int getLengthInSeconds() {
        return tracks.stream()
            .collect(summingInt(Track::getLengthInSeconds));
    }

    public void enrichJson(JsonNode parent) {
        final ObjectNode albumNode = matchingNode(parent);
        albumNode.put("lengthInSeconds", getLengthInSeconds());
    }

    private ObjectNode matchingNode(JsonNode parent) {
        final Stream<JsonNode> albumNodes = StreamSupport.stream(parent.path("album").spliterator(), false)  ;
        return (ObjectNode) albumNodes
            .filter(n -> n.path("title").asText().equals(title))
            .findFirst()
            .get();
    }
    
}
