package com.farhad.example.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IOStreamsDemoTest {

    @Test
    public void demonstrateUseByteStreamsToCopyFileOneByteAtATime() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        String srcfileName = "src/main/resources/sourceFile.txt";
        String destFileName = "src/main/resources/destFile.txt";
        try {
            in = new FileInputStream(srcfileName);
            out = new FileOutputStream(destFileName);

            int c;
            while ( (c = in.read()) != -1 ) {
                out.write(c);        
            }
        } finally {
            if (in != null) {
                in.close();
            } 
            if (out != null) {
                out.close();
            }
        }
    }

    @Test
    public void demonstrateCharacterStreamsToCopyFileOneCharacterAtATime() throws IOException {
        FileReader in = null;
        FileWriter out = null;
        String srcfileName = "src/main/resources/sourceFile.txt";
        String destFileName = "src/main/resources/destFile.txt";

        try {
            in = new FileReader(srcfileName);
            out = new FileWriter(destFileName);

            int c;
            while ( (c = in.read()) != -1 ) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

    }
}


