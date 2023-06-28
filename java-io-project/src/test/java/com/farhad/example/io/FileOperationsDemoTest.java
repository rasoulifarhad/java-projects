package com.farhad.example.io;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileOperationsDemoTest {

    @Test
    public void demonstrateFilesNotExists() {
        Path file = Paths.get("abcdef12345.123");
        assertTrue(Files.notExists(file));
    }

    @Test
    public void demonstrateFileAccessibility() throws IOException {
        Path file = Files.createFile(Paths.get("test.txt"));
        
        log.info("is readable: {}", Files.isReadable(file));
        log.info("is writable: {}", Files.isWritable(file));
        log.info("is executable: {}", Files.isExecutable(file));
        log.info("is regularFile: {}", Files.isRegularFile(file));
    }

    // When you have a file system that uses symbolic links, it is possible to have two different paths that locate the same file.
    @Test
    public void demonstrateFilesIsSameFile() throws IOException {
        Path p1 = Paths.get("home");
        Path p2 = Paths.get("./home");

        Files.createFile(Paths.get("home"));

        assertTrue(Files.isSameFile(p1, p2));
    }

    // The delete(Path) method deletes the file or throws an exception if the deletion fails. For example, if the file does 
    // not exist a NoSuchFileException is thrown.
    //
    // The deleteIfExists(Path) method also deletes the file, but if the file does not exist, no exception is thrown. 
    @Test
    public void demonstrateFilesDelete() throws IOException {

        String fileName = String.format("home%d.txt", new Random().nextInt());
        Path file = Paths.get(fileName);
        assertTrue(Files.notExists(file));

        Files.createFile(file);
        assertTrue(Files.exists(file));

        Files.delete(file);
        log.info("file {} deleted", file);
        assertTrue(Files.notExists(file));
    }

    @Test
    public void demonstrateFilesDeleteThrowsNoSuchFileException() throws IOException {

        String fileName = String.format("home%d.txt", new Random().nextInt());
        Path file = Paths.get(fileName);
        assertTrue(Files.notExists(file));

        assertThrows(
            NoSuchFileException.class,
            () -> Files.delete(file));
    }

    @Test
    public void demonstrateFileDeleteIfExists() throws IOException {
        String fileName = String.format("home%d.txt", new Random().nextInt());
        Path file = Paths.get(fileName);
        assertTrue(Files.notExists(file));

        Files.createFile(file);
        assertTrue(Files.exists(file));

        Files.deleteIfExists(file);
        log.info("file {} deleted", file);
        assertTrue(Files.notExists(file));
    }

    @Test 
    public void demonstrateFilesDeleteIfExistsNotThrowsNoSuchFileException() throws IOException {
        String fileName = String.format("home%d.txt", new Random().nextInt());
        Path file = Paths.get(fileName);
        assertTrue(Files.notExists(file));

        Files.deleteIfExists(file);
        log.info("File {} deleted or not existed", file);
    }

    // copy a file or directory by using the copy(Path, Path, CopyOption...) method. The copy fails if the target file exists, unless 
    // the REPLACE_EXISTING option is specified.
    // Directories can be copied. However, files inside the directory are not copied, so the new directory is empty even when the 
    // original directory contains files.
    // When copying a symbolic link, the target of the link is copied. If you want to copy the link itself, and not the contents of 
    // the link, specify either the NOFOLLOW_LINKS or REPLACE_EXISTING option.
    // The following StandardCopyOption and LinkOption enums are supported:
    // 
    // - REPLACE_EXISTING – Performs the copy even when the target file already exists. If the target is a symbolic link, the link itself is copied (and not the target of the link). If the target is a non-empty directory, the copy fails with the DirectoryNotEmptyException exception.
    // - COPY_ATTRIBUTES – Copies the file attributes associated with the file to the target file. The exact file attributes supported are file system and platform dependent, but last-modified-time is supported across platforms and is copied to the target file.
    // - NOFOLLOW_LINKS – Indicates that symbolic links should not be followed. If the file to be copied is a symbolic link, the link is copied (and not the target of the link).
    // 
    // the Files class also defines methods that may be used to copy between a file and a stream. The copy(InputStream, Path, CopyOptions...) 
    // method may be used to copy all bytes from an input stream to a file. The copy(Path, OutputStream) method may be used to copy all bytes 
    // from a file to an output stream.
    @Test
    public void demonstrateCopyBetweenFileAndStream() {

    }
}
