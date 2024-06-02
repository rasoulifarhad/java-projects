package com.farhad.example.refactoring.load_document.creating_objects_deep;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Service {

    private DataSource dataSource;

    public String tuesdayMusic(String query) {
        try {
            Assortment data = Assortment.fromJson(dataSource.getAlbumList(query));
            return data.toJson();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
