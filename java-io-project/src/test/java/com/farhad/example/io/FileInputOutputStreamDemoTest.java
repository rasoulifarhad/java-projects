package com.farhad.example.io;

import static com.farhad.example.io.FileInputOutputStreamDemo.copyFilesChunk;
import static com.farhad.example.io.FileInputOutputStreamDemo.copyFilesLowlevel;
import static com.farhad.example.io.FileInputOutputStreamDemo.copyFilesOne;
import static com.farhad.example.io.FileInputOutputStreamDemo.CheckPNG.isPNG;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class FileInputOutputStreamDemoTest {

    @Test
    void testCopyFilesChunk() throws IOException {
        String inputFile = "inputFile.dat" ;
        String outputFile = "outputFile.dat";
        // Files.deleteIfExists(Paths.get(inputFile));
        Files.deleteIfExists(Paths.get(outputFile));
        assertTrue(Files.notExists(Paths.get(outputFile)));

        copyFilesLowlevel(inputFile, outputFile);
    }

    @Test
    void testCopyFilesLowlevel() throws IOException {
        String inputFile = "inputFile.dat";
        String outputFile = "outputFile.dat";
        // Files.deleteIfExists(Paths.get(inputFile));
        Files.deleteIfExists(Paths.get(outputFile));
        assertTrue(Files.notExists(Paths.get(outputFile)));

        copyFilesChunk(inputFile, outputFile);
    }

    @Test
    void testCopyFilesOne() throws IOException {
        String inputFile = "inputFile.dat";
        String outputFile = "outputFile.dat";
        // Files.deleteIfExists(Paths.get(inputFile));
        Files.deleteIfExists(Paths.get(outputFile));
        assertTrue(Files.notExists(Paths.get(outputFile)));

        copyFilesOne(inputFile, outputFile);
    }

    @Test
    void testCheckPngTrue() throws IOException {
        String pngFilename = "green.png";
        assertTrue( isPNG(pngFilename) );
    }

    @Test
    void testCheckPngFalse() throws IOException {
        String notAPngFilename = "inputFile.dat";
        assertFalse( isPNG(notAPngFilename) );
    }

}
