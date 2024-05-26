package com.farhad.example.functional_interface.solid.dip.functional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// What we really want
// to do is write some code that finds the headings and delegates the
// details of a file to another method. We can use a Stream<String> as
// the abstraction we want to depend upon rather than a file. A Stream
// is much safer and less open to abuse. We also want to be able to a
// pass in a function that creates our domain exception if there’s a
// problem with the file.
public class HeadingParsing {


    public List<String> findHeadings(Reader input) {
        return withLinesOf(
            input,
            (Stream<String> lines) -> lines.filter(line -> line.endsWith(":"))
                .map(line -> line.substring(0, line.length() -1))
                .collect(Collectors.toList()),
            HeadingLookupException::new
        );

    }

    private <T> T withLinesOf(
        Reader input, 
        Function<Stream<String>, T> handler, 
        Function<IOException, HeadingLookupException> error) {
            
            try (BufferedReader reader = new BufferedReader(input)) {
                return handler.apply(reader.lines());
            } catch (IOException e) {   
                throw error.apply(e);
            }
    }
}
