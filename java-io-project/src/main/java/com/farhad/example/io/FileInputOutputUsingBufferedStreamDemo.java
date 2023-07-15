package com.farhad.example.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileInputOutputUsingBufferedStreamDemo {
    
    private static final int BUFFER_SIZE = 4096;
    public static void copyFiles(String inputFilename, String outputFilename) throws IOException {

        try(
            InputStream in = new BufferedInputStream( new FileInputStream(inputFilename) );
            OutputStream out = new BufferedOutputStream( new FileOutputStream(outputFilename) );
        ) {
            byte [] buffer = new byte[BUFFER_SIZE];
            int bytesReaded;
            while ( (bytesReaded = in.read(buffer)) != -1 ) {
                out.write(buffer, 0, bytesReaded);
            }
        }
    }

    public static void copyFilesWithInternalBufferSize(String inputFilename, String outputFilename) throws IOException {

        int bufferSize = 16384; // 16BB
        try (
            InputStream in = new BufferedInputStream(new FileInputStream(inputFilename), bufferSize);
            OutputStream out = new BufferedOutputStream(new FileOutputStream(outputFilename), bufferSize);
        ) {
            byte [] buffer = new byte[BUFFER_SIZE];
            int bytesReaded;
            while ( (bytesReaded = in.read(buffer)) != -1 ) {
                out.write(buffer, 0, bytesReaded);
            }
        }
    }
}
