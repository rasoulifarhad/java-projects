package com.farhad.example.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmallFilesDemoTest {

    private static final Charset UTF8 = Charset.forName("UTF-8");
    @Test
    public void demonstrateReadAllBytes() throws IOException {
        URL url = this.getClass().getClassLoader().getResource("smallFile.txt");
        Path file = Paths.get(url.getFile());
        byte [] fileArray = Files.readAllBytes(file);
        log.info("{}", fileArray);
    }


    @Test
    public void demonstrateReadAllLines() throws IOException {
        URL url = this.getClass().getClassLoader().getResource("smallFile.txt");
        Path file = Paths.get(url.getFile());
        List<String> lines = Files.readAllLines(file);
        log.info("file: {}. lines: {}", file, lines);
        log.info("{}", file.getFileName());
        log.info("{}", file.getName(0));
        log.info("{}", file.getNameCount());
        log.info("{}", file.getName(file.getNameCount() -1 ));
        log.info("{}", file.getParent());

    }

    @Test
    public void demonstrateFilesWrite() throws IOException {
        URL url = this.getClass().getClassLoader().getResource("smallFile.txt");
        Path readFile = Paths.get(url.getFile());
        byte [] fileArray = Files.readAllBytes(readFile);
        Path parent = readFile.getParent();
        Path writeFile = parent.resolve("copyOPfSmallFile.txt");
        if(Files.exists(writeFile)){
            Files.delete(writeFile);
        } 
        assertFalse(Files.exists(writeFile));
        Files.write(writeFile, fileArray);
        assertTrue(Files.exists(writeFile));
        readAndLogAllLines(writeFile);
    }

    @Test
    public void demonstrateReadingAFileUsingBufferedReader() {
        URL url = this.getClass().getClassLoader().getResource("smallFile.txt");
        Path file = Paths.get(url.getFile());
        // Charset charset = Charset.forName("UTF-8");
        System.out.println(file.getFileName() + " :");
        try(BufferedReader reader = Files.newBufferedReader(file, UTF8)) {
            String line = null;
            while( (line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            log.error("IOException: {}", e);
        }
    }

    @Test
    public void demonstrateWritingAFileUsingBufferedWriter() {
        URL url = this.getClass().getClassLoader().getResource("smallFile.txt");
        Path file = Paths.get(url.getFile());
        Path parent = file.getParent();
        Path writeFile = parent.resolve("sampleWriteFile.txt");
        deleteFile(writeFile);
        assertFalse(Files.exists(writeFile));
        // Charset charset = Charset.forName("UTF-8");
        String s = "test1\ntest2\n";
        try ( BufferedWriter writer = Files.newBufferedWriter(writeFile, UTF8)) {
            writer.write(s, 0, s.length());
        } catch (IOException e) {
            log.error("IOException {}", e);
        }

        assertTrue(Files.exists(writeFile));
        readAndLogAllLines(writeFile);
    }

    @Test
    public void demonstrateReadingFilesUsingStreamIO() {
        Path file = getSmallFileSample();
        try(InputStream in = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            System.out.println(file.getFileName() + " :");
            while( (line = reader.readLine()) != null ) {
                System.out.println(line);
            }
        } catch (IOException e) {

        }
    }


    private void readAndLogAllLines(Path file) {
        try(BufferedReader reader = Files.newBufferedReader(file, UTF8)) {
            String line;
            System.out.println(file.getFileName() + " :");
            while( (line = reader.readLine()) != null ) {
                System.out.println(line);
            }
        } catch (IOException e) {
            log.error("IOException", e);
        }
    }

    private void deleteFile(Path file) {
        try {
            Files.deleteIfExists(file);
        } catch (IOException e) {
            log.info("IOException", e);
        }
    }

    private Path getSmallFileSample() {
        URL url = this.getClass().getClassLoader().getResource("smallFile.txt");
        return Paths.get(url.getFile());
    }

    private Path getSmallFileSampleParent() {
        Path file = getSmallFileSample();
        return file.getParent();
    }
}
