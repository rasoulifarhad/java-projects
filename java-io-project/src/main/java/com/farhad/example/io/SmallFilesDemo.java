package com.farhad.example.io;

import static java.nio.file.StandardOpenOption.READ;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.EnumSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

/**
 * The OpenOptions Parameter
 *
 * Several of the methods in this section take an optional OpenOptions parameter. This parameter is optional and the API tells 
 * you what the default behavior is for the method when none is specified.
 * 
 * The following StandardOpenOptions enums are supported:
 * 
 * - WRITE – Opens the file for write access.
 * - APPEND – Appends the new data to the end of the file. This option is used with the WRITE or CREATE options.
 * - TRUNCATE_EXISTING – Truncates the file to zero bytes. This option is used with the WRITE option.
 * - CREATE_NEW – Creates a new file and throws an exception if the file already exists.
 * - CREATE – Opens the file if it exists or creates a new file if it does not.
 * - DELETE_ON_CLOSE – Deletes the file when the stream is closed. This option is useful for temporary files.
 * - SPARSE – Hints that a newly created file will be sparse. This advanced option is honored on some file systems, such as NTFS, where large files with data "gaps" can be stored in a more efficient manner where those empty gaps do not consume disk space.
 * - SYNC – Keeps the file (both content and metadata) synchronized with the underlying storage device.
 * - DSYNC – Keeps the file content synchronized with the underlying storage device.
 * 
 */

 @Slf4j
public class SmallFilesDemo {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    public static void readFile(Path path) throws IOException {
        readFile(path, EnumSet.of(READ));
    }

    public static void readFile(Path path, Set<? extends OpenOption> options) throws IOException {
        try(ReadableByteChannel rbc = Files.newByteChannel(path, options)) {
            final int BUFFER_CAPACITY = 10;
            ByteBuffer buf = ByteBuffer.allocate(BUFFER_CAPACITY);
            String encoding = System.getProperty("file.encoding");
            while(rbc.read(buf) > 0 ) {
                // Flips this buffer. The limit is set to the current position and then the position is set to zero.
                // After a sequence of channel-read or put operations, invoke this method to prepare for a sequence of channel-write or relative get operations.
                // buf.put(magic);    // Prepend header
                // in.read(buf);      // Read data into rest of buffer
                // buf.flip();        // Flip buffer
                // out.write(buf);    // Write header + data to channe
                buf.flip();
                System.out.print(Charset.forName(encoding).decode(buf));
                buf.clear();  
            }
        }
    }

    public static void readAndLogAllLines(Path file) throws IOException {
        try(BufferedReader reader = Files.newBufferedReader(file, UTF8)) {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } 
    }

}

