package com.farhad.example.refactoring.load_document.raw;

import java.util.Collections;
import java.util.List;

public class Assortment {

    private List<Album> albums;

    public List<Album> getAlbums() {
        return Collections.unmodifiableList(albums);
    }

    
}
