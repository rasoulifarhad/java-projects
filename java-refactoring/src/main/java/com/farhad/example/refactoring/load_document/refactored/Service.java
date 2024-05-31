package com.farhad.example.refactoring.load_document.refactored;

import com.fasterxml.jackson.core.JsonProcessingException;

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

    private String saveAssortment(Assortment data) throws JsonProcessingException {
        return Json.mapper().writeValueAsString(data);
    }

}
