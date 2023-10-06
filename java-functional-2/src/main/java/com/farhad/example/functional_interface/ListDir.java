package com.farhad.example.functional_interface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListDir {
    public static void main(String[] args) throws IOException {
        Files.list(Paths.get("."))
            .filter(Files::isDirectory)
            .forEach(System.out::println);
        
    }
}
