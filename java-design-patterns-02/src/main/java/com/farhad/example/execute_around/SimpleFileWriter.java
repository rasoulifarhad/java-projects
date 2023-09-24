package com.farhad.example.execute_around;

import java.io.FileWriter;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleFileWriter {
    
    public SimpleFileWriter(String path, FileWriterAction action) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        try {
            log.info("writing to file {} started.", path);
            action.writeFile(fileWriter);
            log.info("writing to file {} ented.", path);
        } finally {
            fileWriter.close();
            log.info("file {} closed.", path);
        }
    }
}
