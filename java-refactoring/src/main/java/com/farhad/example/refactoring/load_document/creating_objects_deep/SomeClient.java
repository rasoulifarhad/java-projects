package com.farhad.example.refactoring.load_document.creating_objects_deep;

import java.util.List;
import java.util.stream.Collectors;

public class SomeClient {

    public String doSomething(Assortment assortment) {
        List<Track> tracks = assortment.getTracks();
        return somethingCleverWith(tracks);
    }

    private String somethingCleverWith(List<Track> tracks) {
        return tracks.stream().collect(Collectors.summingInt(Track::getLengthInSeconds)).toString();
    }
}
