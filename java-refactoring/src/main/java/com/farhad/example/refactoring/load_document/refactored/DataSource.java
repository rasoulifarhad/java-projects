package com.farhad.example.refactoring.load_document.refactored;

import com.fasterxml.jackson.core.JsonParser;

public interface DataSource {

    JsonParser getAlbumList(String query);

}
