package com.farhad.example.serialized_entity_pattern;

import java.io.IOException;

public interface CountryDao {
    int insertCountry() throws IOException;
    int selectCountry() throws IOException, ClassNotFoundException;
}
