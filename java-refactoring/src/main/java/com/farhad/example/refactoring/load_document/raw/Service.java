package com.farhad.example.refactoring.load_document.raw;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Service {

    private DataSource dataSource;

    public String tuesdayMusic(String query) {
        try {
            Assortment data = Json.mapper().readValue(dataSource.getAlbumList(query), Assortment.class);
            return Json.mapper().writeValueAsString(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
