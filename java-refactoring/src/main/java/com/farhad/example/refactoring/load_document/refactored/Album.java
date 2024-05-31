package com.farhad.example.refactoring.load_document.refactored;

import java.util.Collections;
import java.util.List;

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


    
}
