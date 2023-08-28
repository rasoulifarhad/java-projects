package com.farhad.example.designpatterns.executearound;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

// See https://java-design-patterns.com/patterns/execute-around/#explanation
@Slf4j
public class App {
	
	public static void main(String[] args) throws IOException {
		FileWriterAction writeHello = writer -> {
			writer.write("Hello World");
		};

		new SimpleFileWriter("testFile.txt", writeHello);

		Scanner scanner = new Scanner(new File("testFile.txt"));
		while (scanner.hasNextLine()) {
			log.info(scanner.nextLine());
		}
	}
}
