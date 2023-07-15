package com.farhad.example.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileInputOutputWithNioDemo {
    
    public static void copySmallFilesNIO(String inputFilename, String outputFilename) throws IOException {
        byte [] allBytes = Files.readAllBytes(Paths.get(inputFilename));
        Files.write(Paths.get(outputFilename), allBytes);
    }
}
