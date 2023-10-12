package com.farhad.example.functional_interface;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class HandleException {
    
    public static void main(String[] args) throws IOException {
        
        Stream.of("/usr", "/tmp")
            .map(path -> {
                try {
                    return new File(path).getCanonicalPath();
                } catch (Exception e) {
                    return e.getMessage();
                }
            })
            .forEach(System.out::println); 
    }
}
