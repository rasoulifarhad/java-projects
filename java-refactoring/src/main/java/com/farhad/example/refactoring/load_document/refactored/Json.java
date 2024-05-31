package com.farhad.example.refactoring.load_document.refactored;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {

    public static ObjectMapper mapper() {
        JsonFactory  f = new JsonFactory();
        f = f.enable(Feature.ALLOW_COMMENTS);
        return new ObjectMapper(f);

    }
}
