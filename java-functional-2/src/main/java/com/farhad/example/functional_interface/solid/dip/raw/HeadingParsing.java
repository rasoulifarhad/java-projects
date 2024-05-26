package com.farhad.example.functional_interface.solid.dip.raw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

public class HeadingParsing {

    public List<String> findHeadings(Reader input) {
        try (BufferedReader reader = new BufferedReader(input)) {
            return reader.lines()
                .filter(line -> line.endsWith(":"))
                .map(line -> line.substring(0,line.length() - 1))
                .collect(Collectors.toList());
        } catch (IOException e) {
            throw new HeadingLookupException(e);
        }
    }
}
