package com.farhad.example.refactoring.load_document.refactored;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Service {

    private DataSource dataSource;

    public String tuesdayMusic(String query) {
        try {
            Assortment data = loadAssotment(query);
            return Json.mapper().writeValueAsString(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private Assortment loadAssotment(String query) {
        try {
            return Json.mapper().readValue(dataSource.getAlbumList(query), Assortment.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
