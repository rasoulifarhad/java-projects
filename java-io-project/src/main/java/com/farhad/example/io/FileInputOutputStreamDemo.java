package com.farhad.example.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileInputOutputStreamDemo {

    public static void copyFilesLowlevel(String inputFilename, String outputFilename) throws IOException {
        try (
            InputStream inputStream = new FileInputStream(inputFilename);
            OutputStream outputStream = new FileOutputStream(outputFilename);
        ) {
            int i;
            while (  (i = inputStream.read()) != -1 ) {
                outputStream.write(i);
            }
        }
    }

    public static void copyFilesOne(String inputFilename, String outputFilename) throws IOException {
        try (
            InputStream in = new FileInputStream(inputFilename);
            OutputStream out = new FileOutputStream(outputFilename);
        ) {
            long length = new File(inputFilename).length();
            byte [] allBytes = new byte[(int)length];
            int bytesReaded = in.read(allBytes);
            out.write(allBytes, 0, bytesReaded);
        }
    }

    private static final int BUFFER_SIZE = 4096;
    public static void copyFilesChunk(String inputFilename, String outputFilename) throws IOException {
        try (
            InputStream in = new FileInputStream(inputFilename);
            OutputStream out = new FileOutputStream(outputFilename);
        ) {
            byte [] buffer = new byte[BUFFER_SIZE];
            int bytesReaded;
            while ( (bytesReaded = in.read(buffer)) != -1 ) {
                out.write(buffer, 0, bytesReaded);
            }
        }
    }

    static class CheckPNG {

        private static int [] pngSignature = {137, 80, 78, 71, 13, 10, 26, 10};
        public static boolean isPNG(String fileName) throws IOException {
            try (
                InputStream in = new FileInputStream(fileName);
            ) {
                int [] headerBytes = new int[8];
                boolean isPng = true;

                for(int i = 0; i < 8 ; i++) {
                    headerBytes[i] = in.read();
                    if (headerBytes[i] != pngSignature[i]) {
                        isPng = false;
                        break;
                    }
                }
                return isPng;
            }
        }
    }
}
