package com.farhad.example.refactoring.load_document.refactored;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;

public class AssortmentTest {

    @Test
    public void enrichedJson() throws Exception {
        JsonNode expected = Json.mapper().readTree("src/test/enrichedJson.json");
        JsonNode actual = Json.mapper().readTree(getAssortment().enrichedJson());
        assertEquals(expected, actual);
    }

    private Assortment getAssortment() {
        return new Assortment();
    }
}
