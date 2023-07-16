package com.farhad.example.io;

import static com.farhad.example.io.FileInputOutputUsingBufferedStreamDemo.copyFiles;
import static com.farhad.example.io.FileInputOutputUsingBufferedStreamDemo.copyFilesWithInternalBufferSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class FileInputOutputUsingBufferedStreamDemoTest {

    @Test
    void testCopyFiles() throws IOException {
        String inputFile = "inputFile.dat";
        String outputFile = "outputFile.dat";
        // Files.deleteIfExists(Paths.get(inputFile));
        Files.deleteIfExists(Paths.get(outputFile));
        assertTrue(Files.notExists(Paths.get(outputFile)));

        copyFiles(inputFile, outputFile);
    }

    @Test
    void testCopyFilesWithInternalBufferSize() throws IOException {
        String inputFile = "inputFile.dat";
        String outputFile = "outputFile.dat";
        // Files.deleteIfExists(Paths.get(inputFile));
        Files.deleteIfExists(Paths.get(outputFile));
        assertTrue(Files.notExists(Paths.get(outputFile)));

        copyFilesWithInternalBufferSize(inputFile, outputFile);
    }
}
