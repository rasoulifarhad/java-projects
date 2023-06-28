package com.farhad.example.io;

import static com.farhad.example.io.SmallFilesDemo.readAndLogAllLines;
import static com.farhad.example.io.SmallFilesDemo.readFile;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void demonstrateWritingAFileUsingBufferedWriter() throws IOException {
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

    @Test
    public void demonstrateWritingFilesUsingStreamIO() throws IOException {
        String s = "Hello world!";
        byte [] data = s.getBytes();
        Path logFile = Paths.get("./logfile.txt");
        try(OutputStream out = new BufferedOutputStream(Files.newOutputStream(logFile,CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException e) {
            log.error("IOException:", e);
        }
        assertTrue(Files.exists(logFile));
        readAndLogAllLines(logFile);
    }

    @Test
    public void demonstrateWritingFilesUsingStreamIODeleteFirst() throws IOException {
        String s = "Hello world!";
        byte [] data = s.getBytes();
        Path logFile = Paths.get("./logfile.txt");
        deleteFile(logFile);
        try(OutputStream out = new BufferedOutputStream(Files.newOutputStream(logFile,CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException e) {
            log.error("IOException:", e);
        }
        assertTrue(Files.exists(logFile));
        readAndLogAllLines(logFile);
    }

    // While stream I/O reads a character at a time, channel I/O reads a buffer at a time. 
    @Test
    public void demonstrateReadingAndWritingFilesUsingChannelIO() {

    }

    @Test
    public void demonstrateCreatesFileOrAppendToFileAlreadyExistWithSpecificSetOfFilePermissionsForPosixSystems() throws IOException {
        Set<OpenOption> options = new HashSet<>();
        options.add(APPEND);
        options.add(CREATE);

        Set<PosixFilePermission> perms = 
            PosixFilePermissions.fromString("rw-r-----");
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);

        // convert string to bytBuffer
        String s = "Hello World! \n";
        byte [] data = s.getBytes();
        ByteBuffer bb = ByteBuffer.wrap(data);

        Path file = Paths.get("./fileWithPermission.txt");

        deleteFile(file);
        assertFalse(Files.exists(file));

        try(SeekableByteChannel sbc = Files.newByteChannel(file, options, attr)) {
            sbc.write(bb);
        } catch (IOException e) {
            log.error("IOException thrown:", e);
        }

        assertTrue(Files.exists(file));
        readFile(file);
        deleteFile(file);

    }

    @Test
    public void demonstrateCreateFiles() {
        Path file = Paths.get("./createFileExample.txt");
        try {
            Files.createFile(file);
            Files.createFile(file);
        } catch (FileAlreadyExistsException e) {
            log.error("File already exists: {}", file, e);
        } catch (IOException e) {
            log.error("create file error: ", e);
        }

        assertTrue(Files.exists(file));

        deleteFile(file);

        assertFalse(Files.exists(file));
    }

    @Test
    public void demonstrateCreateFilesWithOutputStreamIO() throws IOException {
        Path path = Paths.get("./createFileExample.txt");
        deleteFile(path);
        OutputStream out = Files.newOutputStream(path);
        out.close();

        assertTrue(Files.exists(path));
        deleteFile(path);
        assertFalse(Files.exists(path));
    }

    @Test
    public void demonstrateCreateTemporaryFiles() {
        try {
            Path path = Files.createTempFile(null, ".test");
            log.info(" temp file with name {} created", path);
            deleteFile(path);
            assertFalse(Files.exists(path));
        } catch(IOException e) {
            log.error("IOException", e) ;
        }   
    }

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

    private Path getSmallFileSample() {
        URL url = this.getClass().getClassLoader().getResource("smallFile.txt");
        return Paths.get(url.getFile());
    }

    private Path getSmallFileSampleParent() {
        Path file = getSmallFileSample();
        return file.getParent();
    }

    
}
