package com.farhad.example.designpatterns.executearound;

import java.io.FileWriter;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleFileWriter {
	public SimpleFileWriter(String fileName, FileWriterAction action) throws IOException {
		log.info("Openning the file..");
		try (FileWriter writer = new FileWriter(fileName)) {
			log.info("Executing action");
			action.writeFile(writer);
			log.info("closing the file");
		} 
	}
}
