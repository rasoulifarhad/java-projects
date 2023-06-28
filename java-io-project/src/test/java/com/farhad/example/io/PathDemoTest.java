package com.farhad.example.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PathDemoTest {

    @Test
    public void demonstrateCreatePaths() {
        Path p1 = Paths.get("/tmp/tmpFile.txt");
        Path p2 = Paths.get(URI.create("file:///tmp/tmpFile.txt"));
        assertTrue(p1.equals(p2));

        Path p3 = FileSystems.getDefault().getPath("/tmp/tmpFile.txt");
        assertTrue(p2.equals(p3));

        String uHome = System.getProperty("user.home");
        Path p4 = Paths.get(uHome, "logs", "foo.log");
        log.info("Path: {}", p4);
    }

    // Think `Path` as storing these name elements as a sequence. The highest element in the directory structure would be located at index 0. The 
    // lowest element in the directory structure would be located at index [n-1], where n is the number of name elements in the Path. 
    @Test
    public void demonstrateRetrievingInformationFromPath() {
        Path uPath = Paths.get("/home/farhad/foo/bar");
        log.info("To string: {}", uPath.toString());
        log.info("File name: {}", uPath.getFileName());
        log.info("Name at 0: {}", uPath.getName(0));
        log.info("Name count: {}", uPath.getNameCount());
        log.info("Parent: {}", uPath.getParent());
        log.info("Root: {}", uPath.getRoot());
        log.info("sub path(0,2): {}", uPath.subpath(0,2));

        log.info("");

        Path wPath = Paths.get("C:\\home\\farhad\\foo\\bar");
        log.info("To string: {}", wPath.toString());
        log.info("File name: {}", wPath.getFileName());
        log.info("Name at 0: {}", wPath.getName(0));
        log.info("Name count: {}", wPath.getNameCount());
        log.info("Parent: {}", wPath.getParent());
        log.info("Root: {}", wPath.getRoot());
        log.info("sub path(0,1): {}", wPath.subpath(0,1));

        log.info("");
        uPath = Paths.get("foo/bar");
        log.info("To string: {}", uPath.toString());
        log.info("File name: {}", uPath.getFileName());
        log.info("Name at 0: {}", uPath.getName(0));
        log.info("Name count: {}", uPath.getNameCount());
        log.info("Parent: {}", uPath.getParent());
        log.info("Root: {}", uPath.getRoot());
        log.info("sub path(0,2): {}", uPath.subpath(0,2));
    }

    @Test
    public void demonstrateNormalizePath() {
        Path path = Paths.get("/home/./foo/bar") ;
        Path normalizedPath = path.normalize();
        log.info("Normalized path: {}", normalizedPath);

        path = Paths.get("/home/farhad/../foo/bar");
        log.info("Normalized path: {}", normalizedPath);
    }

    // You can use three methods to convert the Path. 
    // 
    // If you need to convert the path to a string that can be opened from a browser, you can use toUri.
    // 
    // The toAbsolutePath method converts a path to an absolute path.
    // 
    // The toRealPath method returns the real path of an existing file.
    @Test
    public void demonstrateConvertingPath() {
        Path pathToUri = Paths.get("/home/farhad/foo/bar.txt");
        log.info("path: {}, Path to URI: {}", pathToUri, pathToUri.toUri());

        Path pathToAbsolute = Paths.get("bar.txt");
        log.info("path: {}, Path to absolute: {}", pathToAbsolute, pathToAbsolute.toAbsolutePath());

        Path pathToReal = Paths.get("bar.txt");
        deleteFile(pathToReal);
        assertThrows(
            NoSuchFileException.class,
            () -> log.info("path: {}, path to real", pathToReal, pathToReal.toRealPath()));
    }

    // Combine paths by using the resolve method. 
    // Pass in a partial path , which is a path that does not include a root element, and that partial path is appended to the original path.
    @Test
    public void demonstrateJoiningTwoPath() {
        Path originalPath = Paths.get("/home/farhad/foo");
        Path partialPath = Paths.get("bar.txt");
        Path expectedPath = Paths.get("/home/farhad/foo/bar.txt");
        log.info("full path: {}", originalPath.resolve(partialPath));
        assertEquals(expectedPath, originalPath.resolve(partialPath));

        Path result =  Paths.get("foo.txt").resolve("/home/farhad/foo");
        log.info("{}", Paths.get("foo.txt").resolve("/home/farhad/foo"));
        expectedPath = originalPath;
        assertEquals(expectedPath, result);
    }

    @Test
    public void demonstrateCreatePathBetweenTwoPaths() {
        Path p1 = Paths.get("farhad");
        Path p2 = Paths.get("ali");
        
        log.info("p1 relativize to p2 : {}", p1.relativize(p2));
        assertEquals(Paths.get("../ali"), p1.relativize(p2));

        log.info("p2 relativize to p1 : {}", p2.relativize(p1));
        assertEquals(Paths.get("../farhad"), p2.relativize(p1));

        Path home = Paths.get("home");
        Path homeFarhadBar = Paths.get("home/farhad/bar");
        
        log.info("home to homeFarhadBar : {}", home.relativize(homeFarhadBar));
        assertEquals(Paths.get("farhad/bar"), home.relativize(homeFarhadBar));

        log.info("homeFarhadBar to home : {}", homeFarhadBar.relativize(home));
        assertEquals(Paths.get("../.."), homeFarhadBar.relativize(home));
    }

    // When you want to verify that two Path objects locate the same file, you can use the isSameFile method,
    @Test
    public void demonstratePathStartsWithAndEndsWith() {
        Path beginning = Paths.get("/home");
        Path ending = Paths.get("bar.txt");
        Path path = Paths.get("/home/farhad/foo/bar.txt");
        assertTrue(path.startsWith(beginning));
        assertTrue(path.endsWith(ending));
    }

    private void deleteFile(Path file) {
        try {
            Files.deleteIfExists(file);
        } catch (IOException e) {
            log.info("IOException", e);
        }
    }

}
