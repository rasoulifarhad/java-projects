package com.farhad.example.io;

import static com.farhad.example.io.FileInputOutputWithNioDemo.copySmallFilesNIO;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class FileInputOutputWithNioDemoTest {

    @Test
    void testCopySmallFilesNIO() throws IOException {

        String inputFile = "inputFile.dat";
        String outputFile = "outputFile.dat";
        Path p = Paths.get(inputFile);
        System.out.println(p.toAbsolutePath());
        // Files.deleteIfExists(Paths.get(inputFile));
        Files.deleteIfExists(Paths.get(outputFile));
        assertTrue(Files.notExists(Paths.get(outputFile)));
        copySmallFilesNIO(inputFile, outputFile);
    }
}
