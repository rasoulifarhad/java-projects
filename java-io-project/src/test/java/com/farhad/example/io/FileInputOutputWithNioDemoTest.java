package com.farhad.example.io;

import static com.farhad.example.io.FileInputOutputWithNioDemo.copySmallFilesNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class FileInputOutputWithNioDemoTest {

    @Test
    void testCopySmallFilesNIO() throws IOException {

        String inputFile = "inputFile.dat";
        String outputFile = "outputFile.dat";
        Files.deleteIfExists(Paths.get(inputFile));
        Files.deleteIfExists(Paths.get(outputFile));
        copySmallFilesNIO(inputFile, outputFile);
    }
}
